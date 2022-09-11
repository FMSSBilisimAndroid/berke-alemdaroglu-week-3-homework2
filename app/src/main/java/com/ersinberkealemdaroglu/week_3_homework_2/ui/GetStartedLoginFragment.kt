package com.ersinberkealemdaroglu.week_3_homework_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ersinberkealemdaroglu.week_3_homework_2.R
import com.ersinberkealemdaroglu.week_3_homework_2.databinding.FragmentGetStartedLoginBinding

class GetStartedLoginFragment : Fragment() {
    private lateinit var getStartedLoginBinding: FragmentGetStartedLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        getStartedLoginBinding = FragmentGetStartedLoginBinding.inflate(inflater)
        return getStartedLoginBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getStartedLoginButtonClick()
    }

    private fun getStartedLoginButtonClick() {
        getStartedLoginBinding.buttonGetStarteds.setOnClickListener {
            findNavController().navigate(R.id.action_getStartedLoginFragment_to_loginFragment)
        }
    }

}