package ru.coronavirus.testapp.di.module

import dagger.Binds
import dagger.Module
import ru.coronavirus.testapp.data.repositoryimpl.CountriesRepositoryImpl
import ru.coronavirus.testapp.data.repositoryimpl.CountriesDbRepositoryImpl
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import ru.coronavirus.testapp.domain.repository.CountriesDbRepository
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