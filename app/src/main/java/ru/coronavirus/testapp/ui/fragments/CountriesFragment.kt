package ru.coronavirus.testapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.databinding.FragmentCountriesBinding
import ru.coronavirus.testapp.ui.MainActivity
import ru.coronavirus.testapp.ui.adapter.CountriesAdapter
import ru.coronavirus.testapp.ui.viewmodel.CountriesViewModel
import javax.inject.Inject


class CountriesFragment : BaseFragment<FragmentCountriesBinding>() {

    @Inject
    lateinit var viewModel: CountriesViewModel
    private val adapter = CountriesAdapter {
        navController.navigate(
            R.id.countryDetailsFragment,
            CountryDetailsFragmentArgs(it).toBundle()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (context as MainActivity).mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel.requestCountries()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_countries, container, false)
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.countriesRV.adapter = adapter
    }
}