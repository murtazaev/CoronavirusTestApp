package ru.coronavirus.testapp.ui.utils

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.coronavirus.testapp.ui.adapter.BindData

@BindingAdapter("bindData")
fun <T> RecyclerView.bindData(list: List<T>) {
    if (adapter is BindData<*>) {
        (adapter as BindData<T>).setData(list)
    }
}

@BindingAdapter("goneIf")
fun View.goneIf(boolean: Boolean) {
    visibility = if (boolean) View.GONE else View.VISIBLE
}

@BindingAdapter("invisibleIf")
fun View.invisibleIf(boolean: Boolean) {
    visibility = if (boolean) View.INVISIBLE else View.VISIBLE
}

@BindingAdapter("visibleIf")
fun View.visibleIf(boolean: Boolean) {
    visibility = if (boolean) View.VISIBLE else View.GONE
}