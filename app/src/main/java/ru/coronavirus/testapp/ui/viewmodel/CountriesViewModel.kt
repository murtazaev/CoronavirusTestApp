package ru.coronavirus.testapp.ui.viewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.usecase.GetCountriesListUseCase
import ru.coronavirus.testapp.domain.usecase.SearchCountriesUseCase
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountriesViewModel @Inject constructor(
    private val getCountries: GetCountriesListUseCase,
    private val searchCountries: SearchCountriesUseCase
) : BaseViewModel() {
    val countries = ObservableArrayList<Countries.Country>()
    val searchStr = ObservableField("")
    val emptySearch = ObservableBoolean(false)
    val error = ObservableBoolean(false)

    var searchDisposable: Disposable? = null

    init {
        searchStr.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                searchCountries()
            }
        })
    }

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

    fun searchCountries() {
        emptySearch.set(false)
        searchDisposable?.dispose()
        searchDisposable = Single
            .fromCallable {
                searchCountries.execute(searchStr.get() ?: "")
            }
            .subscribeOn(Schedulers.io())
            .delaySubscription(300, TimeUnit.MILLISECONDS)
            .subscribe(
                Consumer {
                    if (it.isEmpty()) {
                        emptySearch.set(true)
                        return@Consumer
                    }
                    countries.clear()
                    countries.addAll(it)
                }
            )
            .addTo(compositeDisposable)
    }
}