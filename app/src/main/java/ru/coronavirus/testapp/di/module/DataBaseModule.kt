package ru.coronavirus.testapp.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.coronavirus.testapp.data.datasource.local.CoronavirusDb
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