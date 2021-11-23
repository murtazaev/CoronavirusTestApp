package ru.coronavirus.testapp.domain.usecase

import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import ru.coronavirus.testapp.domain.repository.CoronavirusRepository
import javax.inject.Inject

class GetCountriesListUseCase @Inject constructor(
    private val repo: CoronavirusRepository
) {

    fun execute(): Single<ResponseBody> {
        return repo.getCountriesList()
    }
}