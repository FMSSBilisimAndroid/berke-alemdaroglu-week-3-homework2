package com.ersinberkealemdaroglu.week_3_homework_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ersinberkealemdaroglu.week_3_homework_2.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var signUpBinding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        signUpBinding = FragmentSignUpBinding.inflate(inflater)
        return signUpBinding.root
    }

}