package ru.coronavirus.testapp.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.models.ConfirmedByCountry

interface CountryDetailsRepository {
    fun getConfirmsByCountry(countryName: String, from: String, to: String): Single<List<ConfirmedByCountry>>
}