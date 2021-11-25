package ru.coronavirus.testapp.domain.usecase

import io.reactivex.rxjava3.core.Single
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.domain.repository.CountriesRepository
import ru.coronavirus.testapp.domain.repository.DBCountriesRepository
import javax.inject.Inject

class GetCountriesListUseCase @Inject constructor(
    private val repo: CountriesRepository,
    private val dbRepo: DBCountriesRepository
) {

    fun execute(): Single<Countries> {
        return repo.getCountriesList()
            .doOnSuccess {
                dbRepo.saveCountriesInDb(it.countries)
            }
            .onErrorReturn {
                val countries = dbRepo.getCountriesFromDb()
                if (countries.isEmpty()) {
                    throw it
                } else {
                    Countries(countries)
                }
            }
    }
}