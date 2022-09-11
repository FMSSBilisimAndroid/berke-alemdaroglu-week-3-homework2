package com.ersinberkealemdaroglu.week_3_homework_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ersinberkealemdaroglu.week_3_homework_2.R
import com.ersinberkealemdaroglu.week_3_homework_2.databinding.FragmentGetStartedBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class GetStartedFragment : Fragment() {
    private lateinit var getStartedBinding: FragmentGetStartedBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        getStartedBinding = FragmentGetStartedBinding.inflate(inflater)
        return getStartedBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isLoginControllerAuth()
        getStartedButtonClick()
    }

    private fun getStartedButtonClick() {
        // buttonGetStarted ile getStartedLoginFragment a yönlendiriyor.
        getStartedBinding.buttonGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_getStartedFragment_to_getStartedLoginFragment)
        }
    }

    /**
     * Kullanıcı giriş kontrolü. Eğer kullanıcı giriş yapmışsa homeFragment a direkt yönlendiriliyor.
     */
    private fun isLoginControllerAuth() {
        val currentUser = auth.currentUser
        when {
            currentUser != null -> findNavController().navigate(R.id.action_getStartedFragment_to_home_graph)
            else -> Toast.makeText(context, "Welcome Back!", Toast.LENGTH_SHORT).show()
        }
    }

}