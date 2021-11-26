package ru.coronavirus.testapp.data.repositoryimpl

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.datasource.network.CountryDetailsApi
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.domain.repository.CountryDetailsRepository
import javax.inject.Inject

class CountryDetailsRepositoryImpl @Inject constructor(
    private val api: CountryDetailsApi
) : CountryDetailsRepository {

    override fun getConfirmsByCountry(
        countryName: String,
        from: String,
        to: String
    ): Single<List<Confirm>> {
        return api.getConfirmsByCountry(countryName, from, to)
    }
}