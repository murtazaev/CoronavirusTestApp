package ru.coronavirus.testapp.data.repositoryimpl

import ru.coronavirus.testapp.data.datasource.local.DBCountries
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.DBCountriesRepository
import javax.inject.Inject

class DBCountriesRepositoryImpl @Inject constructor(
    private val db: DBCountries
) : DBCountriesRepository {
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