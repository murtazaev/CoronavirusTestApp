package ru.coronavirus.testapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.databinding.CountryItemBinding
import java.text.DecimalFormat

class CountriesAdapter(
    private val toCountry: (Countries.Country) -> Unit
) : RecyclerView.Adapter<CountriesAdapter.CountryHolder>(),
    BindData<Countries.Country> {

    private var items: List<Countries.Country> = emptyList()
    private val decimalFormatter = DecimalFormat("#,###,###,###")

    override fun setData(items: List<Countries.Country>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        return CountryHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.country_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class CountryHolder(private val binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        lateinit var country: Countries.Country

        init {
            binding.root.setOnClickListener {
                toCountry(country)
            }
        }

        fun bind(country: Countries.Country) {
            this.country = country
            binding.country = country
            binding.holder = this
            binding.executePendingBindings()
        }

        fun formatNumber(number: Int): String {
            return decimalFormatter.format(number.toLong())
        }
    }
}