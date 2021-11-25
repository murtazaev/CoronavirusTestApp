package ru.coronavirus.testapp.data.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.coronavirus.testapp.data.datasource.local.ConfirmedByCountryDb
import ru.coronavirus.testapp.data.datasource.local.CoronavirusDb
import ru.coronavirus.testapp.data.datasource.local.CountriesDb
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideCoronavirusDb(context: Context): CoronavirusDb {
        return Room.databaseBuilder(context, CoronavirusDb::class.java, "coronavirus_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}

@Module
abstract class DataBaseDaoModule {
    @Binds
    abstract fun bindCountriesDb(c: CoronavirusDb): CountriesDb

    @Binds
    abstract fun bindConfirmedByCountryDb(c: CoronavirusDb): ConfirmedByCountryDb
}