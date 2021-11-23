package ru.coronavirus.testapp.data.repositoryimpl

import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import ru.coronavirus.testapp.data.datasource.network.CoronavirusApi
import ru.coronavirus.testapp.domain.repository.CoronavirusRepository
import javax.inject.Inject

class CoronavirusRepositoryImpl @Inject constructor(
    private val api: CoronavirusApi
) : CoronavirusRepository {
    override fun getCountriesList(): Single<ResponseBody> {
        return api.getCountriesList()
    }
}