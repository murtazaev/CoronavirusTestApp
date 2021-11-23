package ru.coronavirus.testapp.viewmodel

import android.util.Log
import ru.coronavirus.testapp.domain.usecase.GetCountriesListUseCase
import javax.inject.Inject

class CountriesViewModel @Inject constructor(
    private val getCountries: GetCountriesListUseCase
) : BaseViewModel() {

    fun getCountries() {
        getCountries.execute()
            .subscribe { t1, t2 ->
                Log.e("LOLOLO", t1.string())
            }
            .addTo(compositeDisposable)
    }

}