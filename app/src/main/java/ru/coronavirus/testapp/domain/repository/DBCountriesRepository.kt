package ru.coronavirus.testapp.domain.repository

import ru.coronavirus.testapp.data.models.Countries

interface DBCountriesRepository {
    fun saveCountriesInDb(countries: List<Countries.Country>)
    fun getCountriesFromDb(): List<Countries.Country>
    fun searchCountries(query: String): List<Countries.Country>
}