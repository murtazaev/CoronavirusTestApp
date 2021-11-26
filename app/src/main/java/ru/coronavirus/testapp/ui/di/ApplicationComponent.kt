package ru.coronavirus.testapp.ui.di

import dagger.Component
import ru.coronavirus.testapp.data.di.*
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        NetworkApiModule::class,
        RepositoryModule::class,
        ContextModule::class,
        DataBaseModule::class,
        DataBaseDaoModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface ApplicationComponent {
    fun mainActivityComponent(): MainActivityComponent.Factory
}