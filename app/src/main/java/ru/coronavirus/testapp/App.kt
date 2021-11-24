package ru.coronavirus.testapp

import android.app.Application
import ru.coronavirus.testapp.ui.di.ApplicationComponent
import ru.coronavirus.testapp.ui.di.ContextModule
import ru.coronavirus.testapp.ui.di.DaggerApplicationComponent

class App : Application() {
    lateinit var appComponent: ApplicationComponent
    override fun onCreate() {
        appComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()
        super.onCreate()
    }
}