package ru.coronavirus.testapp.di

import dagger.Component
import ru.coronavirus.testapp.di.module.NetworkModule
import ru.coronavirus.testapp.di.module.RepositoryModule
import ru.coronavirus.testapp.ui.MainActivity
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, RepositoryModule::class])
@Singleton
interface ApplicationComponent {
    fun countriesComponent() : CountriesSubcomponent.Factory
}