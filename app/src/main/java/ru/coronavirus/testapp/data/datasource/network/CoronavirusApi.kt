package ru.coronavirus.testapp.data.datasource.network

import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import ru.coronavirus.testapp.data.models.Countries

interface CoronavirusApi {

    @GET("summary")
    fun getCountriesList(): Single<Countries>
}