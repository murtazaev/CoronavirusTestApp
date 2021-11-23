package ru.coronavirus.testapp.domain.repository

import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody

interface CoronavirusRepository {
    fun getCountriesList(): Single<ResponseBody>
}