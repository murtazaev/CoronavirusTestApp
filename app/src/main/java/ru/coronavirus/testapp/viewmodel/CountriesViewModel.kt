package ru.coronavirus.testapp.viewmodel

import android.util.Log
import ru.coronavirus.testapp.domain.usecase.GetCountriesListUseCase
import ru.coronavirus.testapp.domain.usecase.SaveCountriesInDbUseCase
import java.lang.NullPointerException
import javax.inject.Inject

class CountriesViewModel @Inject constructor(
    private val getCountries: GetCountriesListUseCase
) : BaseViewModel() {

    fun getCountries() {
        getCountries.execute()
            .onErrorReturn {
                throw NullPointerException("sdfsdfsdf")
            }
            .subscribe { t1, t2 ->

            }
            .addTo(compositeDisposable)
    }

}