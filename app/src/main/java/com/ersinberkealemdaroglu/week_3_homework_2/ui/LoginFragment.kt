package com.ersinberkealemdaroglu.week_3_homework_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ersinberkealemdaroglu.week_3_homework_2.R
import com.ersinberkealemdaroglu.week_3_homework_2.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {
    private lateinit var loginBinding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        loginBinding = FragmentLoginBinding.inflate(inflater)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButtonOnClick()
        signUpButtonClick()
    }

    private fun loginButtonOnClick() {
        loginBinding.loginButton.setOnClickListener {
            val emailText = loginBinding.editTextTextEmailAddress.text.toString()
            val passwordText = loginBinding.editTextTextPassword.text.toString()

            if (emailText == "" && passwordText == ""){
                Toast.makeText(context, "Lütfen Gerekli Alanları Doldurun!", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(emailText, passwordText).addOnSuccessListener {
                    findNavController().navigate(R.id.action_loginFragment_to_home_graph)
                }.addOnFailureListener {
                    Toast.makeText(context, "Girilen Bilgiler Yanlıştır!", Toast.LENGTH_SHORT).show()
                }
            }




        }
    }

    private fun signUpButtonClick(){
        loginBinding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }
}