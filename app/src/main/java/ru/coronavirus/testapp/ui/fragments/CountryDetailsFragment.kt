package ru.coronavirus.testapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.coronavirus.testapp.R
import ru.coronavirus.testapp.data.models.Countries
import ru.coronavirus.testapp.databinding.FragmentCountryDetailsBinding
import ru.coronavirus.testapp.ui.MainActivity
import ru.coronavirus.testapp.ui.viewmodel.CountryDetailViewModel
import javax.inject.Inject

class CountryDetailsFragment : BaseFragment<FragmentCountryDetailsBinding>() {

    @Inject
    lateinit var viewModel: CountryDetailViewModel
    private val args by lazy { CountryDetailsFragmentArgs.fromBundle(requireArguments()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        (context as MainActivity).mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        val country = args.country as Countries.Country
        viewModel.requestDetails(country)
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
}