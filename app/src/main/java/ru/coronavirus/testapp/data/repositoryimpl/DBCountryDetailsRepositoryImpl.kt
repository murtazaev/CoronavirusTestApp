package ru.coronavirus.testapp.data.repositoryimpl

import ru.coronavirus.testapp.data.datasource.local.DBConfirmedByCountry
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.data.models.ConfirmsDBWrapper
import ru.coronavirus.testapp.domain.repository.DBCountryDetailsRepository
import javax.inject.Inject

class DBCountryDetailsRepositoryImpl @Inject constructor(
    private val db: DBConfirmedByCountry
) : DBCountryDetailsRepository {
    override fun saveConfirms(confirms: List<Confirm>) {
        db.confirmsDao().insertConfirms(confirms)
    }

    override fun getCountryConfirms(countryName: String): ConfirmsDBWrapper? {
        return db.confirmsDao().getCountryConfirms(countryName)
    }

}