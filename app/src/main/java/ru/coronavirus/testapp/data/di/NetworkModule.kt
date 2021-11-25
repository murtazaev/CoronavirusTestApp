package ru.coronavirus.testapp.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.coronavirus.testapp.BuildConfig
import ru.coronavirus.testapp.data.datasource.network.CoronavirusApi
import ru.coronavirus.testapp.data.datasource.network.CountriesApi
import ru.coronavirus.testapp.data.datasource.network.CountryDetailsApi
import ru.coronavirus.testapp.data.models.DateSerializer
import java.util.*
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
            serializersModule = SerializersModule {
                contextual(Date::class, DateSerializer())
            }
        }

        val okHttpBuilder = OkHttpClient().newBuilder()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpBuilder.build())
            .build()
    }

    @Provides
    @Singleton
    fun provideCoronavirusApi(retrofit: Retrofit): CoronavirusApi{
        return retrofit.create(CoronavirusApi::class.java)
    }
}

@Module
abstract class NetworkApiModule {
    @Binds
    abstract fun bindCountriesApi(p: CoronavirusApi): CountriesApi

    @Binds
    abstract fun bindCountryDetailsApi(p: CoronavirusApi): CountryDetailsApi
}