package ru.coronavirus.testapp.di

import dagger.Subcomponent
import ru.coronavirus.testapp.ui.MainActivity

@Subcomponent
interface CountriesSubcomponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): CountriesSubcomponent
    }


    fun inject(a: MainActivity)
}