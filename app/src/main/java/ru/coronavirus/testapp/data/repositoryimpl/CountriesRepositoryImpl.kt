package ru.coronavirus.testapp.data.repositoryimpl

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.datasource.local.DBCountries
import ru.coronavirus.testapp.data.datasource.network.CountriesApi
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import ru.coronavirus.testapp.ui.utils.NetworkErrorsHandler
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val api: CountriesApi,
    private val db: DBCountries,
    private val networkErrorHandler: NetworkErrorsHandler
) : CountriesRepository {

    override fun getCountriesList(): Single<Countries> {
        return api.getCountriesList()
            .doAfterSuccess {
                saveCountriesInDb(it.countries)
            }
            .onErrorResumeNext {
                Single.error(networkErrorHandler.handleError(it))
            }
            .onErrorReturn {
                val countries = getCountriesFromDb()
                if (countries.isEmpty()) {
                    throw it
                } else {
                    Countries(countries)
                }
            }
    }

    override fun searchCountries(query: String): List<Countries.Country> {
        return db.countriesDao().searchCountries(query)
    }

    private fun saveCountriesInDb(countries: List<Countries.Country>) {
        db.countriesDao().insertCountries(countries)
    }

    private fun getCountriesFromDb(): List<Countries.Country> {
        return db.countriesDao().getCountries()
    }

}