package ru.coronavirus.testapp.data.datasource.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.data.models.Countries

//Мало конечно методов для сегригации, но в тестовом думаю можно
interface CoronavirusApi : CountriesApi, CountryDetailsApi

interface CountriesApi {
    @GET("summary")
    fun getCountriesList(): Single<Countries>
}

interface CountryDetailsApi {
    @GET("total/country/{countryName}/status/confirmed")
    fun getConfirmsByCountry(
        @Path("countryName") countryName: String,
        @Query("from") from: String,
        @Query("to") to: String
    ): Single<List<Confirm>>
}