package ru.coronavirus.testapp.di.module

import dagger.Binds
import dagger.Module
import ru.coronavirus.testapp.data.repositoryimpl.CoronavirusRepositoryImpl
import ru.coronavirus.testapp.domain.repository.CoronavirusRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCoronavirusRepo(r: CoronavirusRepositoryImpl): CoronavirusRepository

}