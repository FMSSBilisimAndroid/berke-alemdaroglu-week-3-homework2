package com.ersinberkealemdaroglu.week_3_homework_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ersinberkealemdaroglu.week_3_homework_2.R
import com.ersinberkealemdaroglu.week_3_homework_2.databinding.FragmentGetStartedBinding

class GetStartedFragment : Fragment() {
    private lateinit var getStartedBinding: FragmentGetStartedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        getStartedBinding = FragmentGetStartedBinding.inflate(inflater)
        return getStartedBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getStartedButtonClick()
    }

    private fun getStartedButtonClick() {
        getStartedBinding.buttonGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_getStartedFragment_to_getStartedLoginFragment)
        }
    }

}