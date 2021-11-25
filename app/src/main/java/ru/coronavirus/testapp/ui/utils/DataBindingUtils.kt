package ru.coronavirus.testapp.ui.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.coronavirus.testapp.ui.adapter.BindData

@BindingAdapter("bindData")
fun <T> RecyclerView.bindData(list: List<T>) {
    if (adapter is BindData<*>) {
        (adapter as BindData<T>).setData(list)
    }
}