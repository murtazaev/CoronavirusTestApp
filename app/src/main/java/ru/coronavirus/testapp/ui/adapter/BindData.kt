package ru.coronavirus.testapp.ui.adapter

interface BindData<T> {
    fun setData(items: List<T>)
}