package ru.coronavirus.testapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding> : Fragment() {
    protected val navController by lazy { findNavController() }
    protected var _binding: B? = null
    protected val binding: B get() = requireNotNull(_binding)

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}