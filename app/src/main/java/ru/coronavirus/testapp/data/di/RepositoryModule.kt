package ru.coronavirus.testapp.data.di

import dagger.Binds
import dagger.Module
import ru.coronavirus.testapp.data.repositoryimpl.CountriesDbRepositoryImpl
import ru.coronavirus.testapp.data.repositoryimpl.CountriesRepositoryImpl
import ru.coronavirus.testapp.domain.repository.CountriesDbRepository
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCoronavirusRepo(r: CountriesRepositoryImpl): CountriesRepository

    @Binds
    @Singleton
    abstract fun bindCountriesDbRepo(r: CountriesDbRepositoryImpl): CountriesDbRepository

}