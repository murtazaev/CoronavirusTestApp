package ru.coronavirus.testapp.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.models.Countries

interface CountriesRepository {
    fun getCountriesList(): Single<Countries>
    fun searchCountries(query: String): List<Countries.Country>
}