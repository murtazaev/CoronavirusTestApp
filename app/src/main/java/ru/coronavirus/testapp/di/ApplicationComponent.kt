package ru.coronavirus.testapp.di

import dagger.Component
import ru.coronavirus.testapp.di.module.ContextModule
import ru.coronavirus.testapp.di.module.DataBaseModule
import ru.coronavirus.testapp.di.module.NetworkModule
import ru.coronavirus.testapp.di.module.RepositoryModule
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        ContextModule::class,
        DataBaseModule::class
    ]
)
@Singleton
interface ApplicationComponent {
    fun countriesComponent(): CountriesSubcomponent.Factory
}