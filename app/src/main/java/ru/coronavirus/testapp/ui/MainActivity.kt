package ru.coronavirus.testapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import ru.coronavirus.testapp.App
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.ui.di.MainActivityComponent
import ru.coronavirus.testapp.ui.viewmodel.CountriesViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val navController by lazy { findNavController(R.id.container) }

    lateinit var mainComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (applicationContext as App).appComponent.mainActivityComponent().create()
        super.onCreate(savedInstanceState)
    }
}