package ru.coronavirus.testapp.domain.usecase

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.datasource.local.DBConfirmedByCountry
import ru.coronavirus.testapp.data.datasource.network.CountryDetailsApi
import ru.coronavirus.testapp.data.models.ConfirmedByCountry
import javax.inject.Inject

class GetCountryDetailsUseCase @Inject constructor(
    private val api: CountryDetailsApi,
    private val db: DBConfirmedByCountry
) {

    fun execute(countyName: String, from: String, to: String): Single<List<ConfirmedByCountry>> {
        return api.getConfirmsByCountry(countyName, from, to)
            .doAfterSuccess {

            }
            .doOnError {

            }
    }
}