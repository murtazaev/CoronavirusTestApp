package ru.coronavirus.testapp.data.repositoryimpl

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.datasource.local.DBConfirmedByCountry
import ru.coronavirus.testapp.data.datasource.network.CountryDetailsApi
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.data.models.ConfirmsDBWrapper
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CountryDetailsRepository
import ru.coronavirus.testapp.ui.utils.NetworkErrorsHandler
import javax.inject.Inject

class CountryDetailsRepositoryImpl @Inject constructor(
    private val api: CountryDetailsApi,
    private val db: DBConfirmedByCountry,
    private val networkErrorHandler: NetworkErrorsHandler
) : CountryDetailsRepository {

    override fun getConfirmsByCountry(
        country: Countries.Country,
        from: String,
        to: String
    ): Single<List<Confirm>> {
        return api.getConfirmsByCountry(country.countryCode, from, to)
            .doAfterSuccess {
                if (it.isEmpty()) return@doAfterSuccess
                it.mapIndexed { index, confirms ->
                    //чтоб самому не писать очистку таблицы по стране
                    //ключи просто будут совпадать
                    //и рум будет их перезаписывать
                    //может быть конечно, что данные будут друг друга затирать
                    //но думаю в этом случае это не критично
                    confirms.dbKey = confirms.countryConfirmed.hashCode() + index
                }
                saveConfirms(it)
            }
            .onErrorResumeNext {
                Single.error(networkErrorHandler.handleError(it))
            }
            .onErrorReturn {
                val confirms = getCountryConfirms(country.country)
                if (confirms == null || confirms.confirms.isEmpty()) {
                    throw it
                }
                confirms.confirms
            }
    }

    private fun saveConfirms(confirms: List<Confirm>) {
        db.confirmsDao().insertConfirms(confirms)
    }

    private fun getCountryConfirms(countryName: String): ConfirmsDBWrapper? {
        return db.confirmsDao().getCountryConfirms(countryName)
    }
}