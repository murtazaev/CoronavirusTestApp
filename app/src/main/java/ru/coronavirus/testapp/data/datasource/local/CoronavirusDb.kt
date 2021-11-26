package ru.coronavirus.testapp.data.datasource.local

import androidx.room.*
import ru.coronavirus.testapp.data.models.*

@Database(
    entities = [
        Countries.Country::class,
        Confirm::class
    ],
    version = 1
)
@TypeConverters(DateTypeConverter::class)
abstract class CoronavirusDb : RoomDatabase(), DBCountries, DBConfirmedByCountry

interface DBCountries {
    fun countriesDao(): CountriesDao
}

interface DBConfirmedByCountry {
    fun confirmsDao(): ConfirmedByCountryDao
}

@Dao
interface CountriesDao {
    @Query("SELECT * FROM country ORDER BY country")
    fun getCountries(): List<Countries.Country>

    @Query("SELECT * FROM country WHERE country LIKE '%' || :query || '%' ORDER BY country")
    fun searchCountries(query: String): List<Countries.Country>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(countries: List<Countries.Country>)

    @Query("DELETE FROM country")
    fun clearCounties()
}

@Dao
interface ConfirmedByCountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertConfirms(c: List<Confirm>)

    @Query("SELECT * FROM country WHERE country == :countryName")
    fun getCountryConfirms(countryName: String): ConfirmsDBWrapper?
}