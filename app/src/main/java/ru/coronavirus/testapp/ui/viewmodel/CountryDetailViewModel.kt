package ru.coronavirus.testapp.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.usecase.GetCountryDetailsUseCase
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryDetailViewModel @Inject constructor(
    private val context: Context,
    private val getDetails: GetCountryDetailsUseCase
) : BaseViewModel() {

    val country = ObservableField<Countries.Country>()
    val confirmsInTwoWeeks: MutableLiveData<List<Confirm>> = MutableLiveData()


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
            simpleDateFormat.format(Date())
        )
            .doFinally {
                isLoading = false
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    confirmsInTwoWeeks.value = it
                    Log.e("SUCCESS", "${it}")
                },
                {
                    error = true
                    Log.e("ERROR", it.message.toString())
                }
            )
            .addTo(compositeDisposable)
    }

    fun buildChartData(confirms: List<Confirm>): BarData {
        val entry = ArrayList<BarEntry>()
        confirms.forEachIndexed { index, it ->
            entry.add(BarEntry(index.toFloat(), it.cases.toFloat()))
        }
        val dataSet = BarDataSet(entry, context.getString(R.string.morbidity_by_days))
        dataSet.setColors(intArrayOf(R.color.red), context)
        return BarData(dataSet).apply {
            this.setValueTextSize(0f)
        }
    }
}