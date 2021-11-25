package ru.coronavirus.testapp.data.repositoryimpl

import ru.coronavirus.testapp.data.datasource.local.ConfirmedByCountryDb
import ru.coronavirus.testapp.domain.repository.DBCountryDetailsRepository
import javax.inject.Inject

class DBCountryDetailsRepositoryImpl @Inject constructor(
    private val db: ConfirmedByCountryDb
) : DBCountryDetailsRepository {
}