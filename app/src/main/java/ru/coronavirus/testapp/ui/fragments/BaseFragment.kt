package ru.coronavirus.testapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<B : ViewBinding> : Fragment() {
    protected val navController by lazy { findNavController() }
    protected var _binding: B? = null
    protected val binding: B get() = requireNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!initialRequestDataAlreadyLoaded()) {
            initialRequest()
        }
    }

    abstract fun initialRequest()

    open fun initialRequestDataAlreadyLoaded(): Boolean {
        return false
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}