package ru.coronavirus.testapp.data.di

import dagger.Binds
import dagger.Module
import ru.coronavirus.testapp.data.repositoryimpl.CountriesRepositoryImpl
import ru.coronavirus.testapp.data.repositoryimpl.CountryDetailsRepositoryImpl
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import ru.coronavirus.testapp.domain.repository.CountryDetailsRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCoronavirusRepo(r: CountriesRepositoryImpl): CountriesRepository

    @Binds
    @Singleton
    abstract fun bindCountryDetailsRepo(r: CountryDetailsRepositoryImpl): CountryDetailsRepository
}