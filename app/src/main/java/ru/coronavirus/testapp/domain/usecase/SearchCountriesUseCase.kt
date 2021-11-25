package ru.coronavirus.testapp.domain.usecase

import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.DBCountriesRepository
import javax.inject.Inject

class SearchCountriesUseCase @Inject constructor(
    private val dbRepo: DBCountriesRepository
) {
    fun execute(query: String): List<Countries.Country> {
        return dbRepo.searchCountries(query)
    }
}