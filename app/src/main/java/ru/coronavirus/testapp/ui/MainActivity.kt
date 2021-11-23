package ru.coronavirus.testapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.coronavirus.testapp.App
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.viewmodel.CountriesViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: CountriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.countriesComponent().create().inject(this)
        Log.e("VIEWMODEL", viewModel.toString())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getCountries()
    }
}