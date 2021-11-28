package ru.coronavirus.testapp.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.usecase.GetCountryDetailsUseCase
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

class CountryDetailViewModel @Inject constructor(
    private val context: Context,
    private val getDetails: GetCountryDetailsUseCase
) : BaseViewModel() {

    val country = ObservableField<Countries.Country>()
    val confirmsInTwoWeeks = ObservableArrayList<Confirm>()

    private val simpleDateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'", Locale.getDefault())

    //минута в милисекундах * минут в часе * часов в дне * дней в двух неделях
    private val twoWeeksInMillis = 60000 * 60 * 24 * 14

    fun requestDetails(country: Countries.Country) {
        error = false
        isLoading = true
        getDetails.execute(
            country,
            simpleDateFormat.format(Date(System.currentTimeMillis() - twoWeeksInMillis)),
            //На сервере ошибка, если нет данных на текущую дату, то он начинает возвращать всю историю
            //поэтому отнимаю сутки
            simpleDateFormat.format(Date(System.currentTimeMillis() - 60000 * 60 * 24))
        )
            .doFinally {
                isLoading = false
            }
            .subscribe(
                {
                    confirmsInTwoWeeks.addAll(it)
                },
                {
                    error = true
                }
            )
            .addTo(compositeDisposable)
    }
}