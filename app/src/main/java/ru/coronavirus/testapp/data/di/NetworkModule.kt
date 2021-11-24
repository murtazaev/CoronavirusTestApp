package ru.coronavirus.testapp.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.coronavirus.testapp.BuildConfig
import ru.coronavirus.testapp.data.datasource.network.CoronavirusApi
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
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