package ru.coronavirus.testapp.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.data.models.ConfirmsDBWrapper
import ru.coronavirus.testapp.data.models.Countries

interface CountryDetailsRepository {
    fun getConfirmsByCountry(country: Countries.Country, from: String, to: String): Single<List<Confirm>>
}