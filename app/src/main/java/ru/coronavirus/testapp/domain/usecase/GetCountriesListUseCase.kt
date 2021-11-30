package ru.coronavirus.testapp.domain.usecase

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import javax.inject.Inject

class GetCountriesListUseCase @Inject constructor(
    private val repo: CountriesRepository
) {

    fun execute(): Single<Countries> {
        return repo.getCountriesList()
    }
}