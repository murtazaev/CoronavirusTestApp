package ru.coronavirus.testapp.data.repositoryimpl

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.datasource.local.CoronavirusDb
import ru.coronavirus.testapp.data.datasource.network.CoronavirusApi
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CoronavirusRepository
import javax.inject.Inject

class CoronavirusRepositoryImpl @Inject constructor(
    private val api: CoronavirusApi,
    private val db: CoronavirusDb
) : CoronavirusRepository {
    override fun getCountriesList(): Single<Countries> {
        return api.getCountriesList()
    }

    override fun saveCountriesInDb(countries: List<Countries.Country>) {
        db.countriesDao().updateCountries(countries)
    }

    override fun getCountriesFromDb(): List<Countries.Country> {
        return db.countriesDao().getCountries()
    }
}