package ru.coronavirus.testapp.domain.usecase

import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import javax.inject.Inject

class SearchCountriesUseCase @Inject constructor(
    private val repo: CountriesRepository
) {
    fun execute(query: String): List<Countries.Country> {
        return repo.searchCountries(query)
    }
}