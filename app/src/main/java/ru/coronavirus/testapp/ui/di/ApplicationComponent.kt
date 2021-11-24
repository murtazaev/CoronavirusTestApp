package ru.coronavirus.testapp.ui.di

import dagger.Component
import ru.coronavirus.testapp.data.di.DataBaseModule
import ru.coronavirus.testapp.data.di.NetworkModule
import ru.coronavirus.testapp.data.di.RepositoryModule
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
    fun mainActivityComponent(): MainActivityComponent.Factory
}