package ru.coronavirus.testapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.databinding.FragmentCountryDetailsBinding
import ru.coronavirus.testapp.ui.MainActivity
import ru.coronavirus.testapp.ui.adapter.ConfirmsAdapter
import ru.coronavirus.testapp.ui.viewmodel.CountryDetailViewModel

//Думал заюзать либу для графиков, но решил ресайклером обойтись
class CountryDetailsFragment : BaseFragment<FragmentCountryDetailsBinding>() {

    val viewModel: CountryDetailViewModel by viewModels { viewModelFactory }
    private val args by lazy { CountryDetailsFragmentArgs.fromBundle(requireArguments()) }
    private val adapter = ConfirmsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        (context as MainActivity).mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        val country = args.country as Countries.Country
        viewModel.requestDetails(country)
        viewModel.country.set(country)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_country_details, container, false)
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.run {
            confirmsByDays.adapter = adapter
        }
    }
}