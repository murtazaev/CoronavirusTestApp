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
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

//Думал заюзать либу для графиков, но решил ресайклером обойтись
class CountryDetailsFragment : BaseFragment<FragmentCountryDetailsBinding>() {

    val viewModel: CountryDetailViewModel by viewModels { viewModelFactory }
    private val args by lazy { CountryDetailsFragmentArgs.fromBundle(requireArguments()) }

    private val adapter = ConfirmsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        (context as MainActivity).mainComponent.inject(this)
        viewModel.country.set(args.country)
        super.onCreate(savedInstanceState)
    }

    override fun initialRequest() {
        viewModel.requestDetails()
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