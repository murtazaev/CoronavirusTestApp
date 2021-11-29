package ru.coronavirus.testapp.domain.repository

import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.data.models.ConfirmsDBWrapper

interface DBCountryDetailsRepository {
    fun saveConfirms(confirms: List<Confirm>)
    fun getCountryConfirms(countryName: String): ConfirmsDBWrapper?
}