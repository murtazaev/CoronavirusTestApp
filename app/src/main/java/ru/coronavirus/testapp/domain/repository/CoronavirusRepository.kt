package ru.coronavirus.testapp.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.models.Countries

interface CoronavirusRepository {
    fun getCountriesList(): Single<Countries>
    fun saveCountriesInDb(countries: List<Countries.Country>)
    fun getCountriesFromDb(): List<Countries.Country>
}