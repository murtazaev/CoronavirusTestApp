package ru.coronavirus.testapp.data.datasource.local

import androidx.room.*
import ru.coronavirus.testapp.data.models.Countries

@Database(
    entities = [Countries.Country::class],
    version = 1
)
abstract class CoronavirusDb : RoomDatabase() {
    abstract fun countriesDao(): CountriesDao
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(countries: List<Countries.Country>)

    @Query("DELETE FROM country")
    fun clearCounties()
}