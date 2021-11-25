package ru.coronavirus.testapp.data.repositoryimpl

import ru.coronavirus.testapp.data.datasource.local.CoronavirusDb
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CountriesDbRepository
import javax.inject.Inject

class CountriesDbRepositoryImpl @Inject constructor(
    private val db: CoronavirusDb
) : CountriesDbRepository {
    override fun saveCountriesInDb(countries: List<Countries.Country>) {
        db.countriesDao().updateCountries(countries)
    }

    override fun getCountriesFromDb(): List<Countries.Country> {
        return db.countriesDao().getCountries()
    }

    override fun searchCountries(query: String): List<Countries.Country> {
        return db.countriesDao().searchCountries(query)
    }
}