package ru.coronavirus.testapp.ui.di

import dagger.Subcomponent
import ru.coronavirus.testapp.ui.MainActivity
import ru.coronavirus.testapp.ui.fragments.CountriesFragment
import ru.coronavirus.testapp.ui.fragments.CountryDetailsFragment

@Subcomponent
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(a: MainActivity)
    fun inject(f: CountriesFragment)
    fun inject(f: CountryDetailsFragment)
}