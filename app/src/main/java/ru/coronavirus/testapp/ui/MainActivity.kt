package ru.coronavirus.testapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import ru.coronavirus.testapp.App
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.viewmodel.CountriesViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val navController by lazy { findNavController(R.id.container) }

    @Inject
    lateinit var viewModel: CountriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.countriesComponent().create().inject(this)
        super.onCreate(savedInstanceState)
    }
}