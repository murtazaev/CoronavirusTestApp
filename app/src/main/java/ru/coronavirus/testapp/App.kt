package ru.coronavirus.testapp

import android.app.Application
import ru.coronavirus.testapp.di.DaggerApplicationComponent

class App : Application() {
    val appComponent = DaggerApplicationComponent.create()
}