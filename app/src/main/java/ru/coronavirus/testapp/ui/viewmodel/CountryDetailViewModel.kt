package ru.coronavirus.testapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import ru.coronavirus.testapp.domain.usecase.GetCountryDetailsUseCase
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryDetailViewModel @Inject constructor(
    private val getDetails: GetCountryDetailsUseCase
) : BaseViewModel() {
    private val simpleDateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'", Locale.getDefault())

    //минута в милисекундах * минут в часе * часов в дне * дней в двух неделях
    private val twoWeeksInMillis = 60000 * 60 * 24 * 14

    fun requestDetails() {

        getDetails.execute(
            "Russia",
            simpleDateFormat.format(Date(System.currentTimeMillis() - twoWeeksInMillis)),
            simpleDateFormat.format(Date())
        )
            .subscribe(
                {
                    Log.e("DETAILS", "$it")
                },
                {
                    Log.e("DETAILSERROR", "$it")
                }
            )
            .addTo(compositeDisposable)
    }
}