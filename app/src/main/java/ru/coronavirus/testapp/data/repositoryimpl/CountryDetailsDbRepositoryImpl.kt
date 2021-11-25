package ru.coronavirus.testapp.data.repositoryimpl

import ru.coronavirus.testapp.data.datasource.local.ConfirmedByCountryDb
import ru.coronavirus.testapp.domain.repository.CountryDetailsDbRepository
import javax.inject.Inject

class CountryDetailsDbRepositoryImpl @Inject constructor(
    private val db: ConfirmedByCountryDb
) : CountryDetailsDbRepository {
}