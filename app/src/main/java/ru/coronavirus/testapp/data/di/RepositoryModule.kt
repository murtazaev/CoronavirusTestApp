package ru.coronavirus.testapp.data.di

import dagger.Binds
import dagger.Module
import ru.coronavirus.testapp.data.repositoryimpl.CountriesRepositoryImpl
import ru.coronavirus.testapp.data.repositoryimpl.CountryDetailsRepositoryImpl
import ru.coronavirus.testapp.data.repositoryimpl.DBCountriesRepositoryImpl
import ru.coronavirus.testapp.data.repositoryimpl.DBCountryDetailsRepositoryImpl
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import ru.coronavirus.testapp.domain.repository.CountryDetailsRepository
import ru.coronavirus.testapp.domain.repository.DBCountriesRepository
import ru.coronavirus.testapp.domain.repository.DBCountryDetailsRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCoronavirusRepo(r: CountriesRepositoryImpl): CountriesRepository

    @Binds
    @Singleton
    abstract fun bindCountriesDbRepo(r: DBCountriesRepositoryImpl): DBCountriesRepository

    @Binds
    @Singleton
    abstract fun bindCountryDetailsRepo(r: CountryDetailsRepositoryImpl): CountryDetailsRepository

    @Binds
    @Singleton
    abstract fun bindDBCountryDetailsRepo(r: DBCountryDetailsRepositoryImpl): DBCountryDetailsRepository
}