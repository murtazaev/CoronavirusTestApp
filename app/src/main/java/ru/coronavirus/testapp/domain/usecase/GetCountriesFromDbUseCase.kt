package ru.coronavirus.testapp.domain.usecase

import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CoronavirusRepository
import javax.inject.Inject

class GetCountriesFromDbUseCase  @Inject constructor(
    private val repo: CoronavirusRepository
)  {

    fun execute(): List<Countries.Country> {
        return repo.getCountriesFromDb()
    }
}