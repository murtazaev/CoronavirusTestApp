package ru.coronavirus.testapp.data.repositoryimpl

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.datasource.local.CoronavirusDb
import ru.coronavirus.testapp.data.datasource.network.CoronavirusApi
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val api: CoronavirusApi,
    private val db: CoronavirusDb
) : CountriesRepository {
    override fun getCountriesList(): Single<Countries> {
        return api.getCountriesList()
    }
}