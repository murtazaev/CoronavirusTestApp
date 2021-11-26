package ru.coronavirus.testapp.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import ru.coronavirus.testapp.ui.viewmodel.CountriesViewModel
import ru.coronavirus.testapp.ui.viewmodel.CountryDetailViewModel
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CountriesViewModel::class)
    abstract fun bindCountriesViewModel(vm: CountriesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountryDetailViewModel::class)
    abstract fun bindCountryDetailViewModel(vm: CountryDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}