package ru.coronavirus.testapp.data.datasource.local

import androidx.room.*
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.data.models.DateTypeConverter

@Database(
    entities = [Countries.Country::class],
    version = 1
)
@TypeConverters(DateTypeConverter::class)
abstract class CoronavirusDb : RoomDatabase(), DBCountries, DBConfirmedByCountry

interface DBCountries{
    fun countriesDao(): CountriesDao
}
interface DBConfirmedByCountry{
    fun confirmsDao(): ConfirmedByCountryDao
}

@Dao
interface CountriesDao {

    @Transaction
    fun updateCountries(countries: List<Countries.Country>){
        clearCounties()
        insertCountries(countries)
    }

    @Query("SELECT * FROM country")
    fun getCountries(): List<Countries.Country>

    @Query("SELECT * FROM country WHERE country LIKE  '%' || :query OR countryCode LIKE :query")
    fun searchCountries(query: String): List<Countries.Country>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(countries: List<Countries.Country>)

    @Query("DELETE FROM country")
    fun clearCounties()
}

@Dao
interface ConfirmedByCountryDao {


}