package ru.coronavirus.testapp.ui.viewmodel

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.usecase.GetCountriesListUseCase
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountriesViewModel @Inject constructor(
    private val getCountries: GetCountriesListUseCase
) : BaseViewModel() {
    val countries = ObservableArrayList<Countries.Country>()
    val error = ObservableBoolean(false)

    fun requestCountries() {
        error.set(false)
        getCountries.execute()
            .subscribe(
                { mCountries ->
                    countries.clear()
                    countries.addAll(mCountries.countries)
                },
                { mError ->
                    error.set(true)
                }
            )
            .addTo(compositeDisposable)
    }
}