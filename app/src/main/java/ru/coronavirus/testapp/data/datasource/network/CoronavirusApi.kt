package ru.coronavirus.testapp.data.datasource.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.coronavirus.testapp.data.models.ConfirmedByCountry
import ru.coronavirus.testapp.data.models.Countries

interface CoronavirusApi {

    @GET("summary")
    fun getCountriesList(): Single<Countries>

    @GET("total/country/{countryName}/status/confirmed")
    fun getCountryDetail(
        @Path("countryName") countryName: String,
        @Query("from") from: String,
        @Query("to") to: String
    ): Single<List<ConfirmedByCountry>>
}