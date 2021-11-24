package ru.coronavirus.testapp.domain.repository

import ru.coronavirus.testapp.data.models.Countries

interface CountriesDbRepository {
    fun saveCountriesInDb(countries: List<Countries.Country>)
    fun getCountriesFromDb(): List<Countries.Country>
}