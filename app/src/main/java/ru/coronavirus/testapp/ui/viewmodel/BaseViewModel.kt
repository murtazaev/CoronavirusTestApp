package ru.coronavirus.testapp.ui.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()
    val isLoadingObservable = ObservableBoolean(false)
    val errorObservable = ObservableBoolean(false)
    val errorText = ObservableField("")

    var isLoading: Boolean
        get() = isLoadingObservable.get()
        set(value) {
            isLoadingObservable.set(value)
        }
    var error: Boolean
        get() = errorObservable.get()
        set(value) {
            errorObservable.set(value)
        }

    abstract fun retryLoad()

    override fun onCleared() {
        compositeDisposable.clear()
    }
}

fun Disposable.addTo(disposable: CompositeDisposable): Disposable = apply { disposable.add(this) }