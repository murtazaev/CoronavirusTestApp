package ru.coronavirus.testapp.domain.usecase

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CountryDetailsRepository
import javax.inject.Inject

class GetCountryDetailsUseCase @Inject constructor(
    private val api: CountryDetailsRepository
) {

    fun execute(county: Countries.Country, from: String, to: String): Single<List<Confirm>> {
        return api.getConfirmsByCountry(county, from, to)
    }
}