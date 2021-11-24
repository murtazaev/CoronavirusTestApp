package ru.coronavirus.testapp

import android.app.Application
import ru.coronavirus.testapp.di.ApplicationComponent
import ru.coronavirus.testapp.di.DaggerApplicationComponent
import ru.coronavirus.testapp.di.module.ContextModule

class App : Application() {
    lateinit var appComponent: ApplicationComponent
    override fun onCreate() {
        appComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()
        super.onCreate()
    }
}