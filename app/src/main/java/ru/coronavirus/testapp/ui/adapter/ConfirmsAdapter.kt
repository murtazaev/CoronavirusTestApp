package ru.coronavirus.testapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.data.models.Confirm
import ru.coronavirus.testapp.databinding.ConfirmedItemBinding
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class ConfirmsAdapter : RecyclerView.Adapter<ConfirmsAdapter.ConfirmedHolder>(), BindData<Confirm> {

    private var items: List<Confirm> = emptyList()
    private val dateFormat = SimpleDateFormat("dd MMMM", Locale.getDefault())
    private val decimalFormat = DecimalFormat("#,###,###,###")

    override fun setData(items: List<Confirm>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfirmedHolder {
        return ConfirmedHolder(
            ConfirmedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ConfirmedHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size


    inner class ConfirmedHolder(
        private val binding: ConfirmedItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(confirmed: Confirm) {
            binding.run {
                casesOnDate.text = casesOnDate.context.resources.getQuantityString(
                    R.plurals.cases_on_date,
                    confirmed.cases,
                    decimalFormat.format(confirmed.cases.toLong()),
                    dateFormat.format(confirmed.date)
                )
            }
        }
    }
}