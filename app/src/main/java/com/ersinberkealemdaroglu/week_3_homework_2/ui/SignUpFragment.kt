package com.ersinberkealemdaroglu.week_3_homework_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ersinberkealemdaroglu.week_3_homework_2.R
import com.ersinberkealemdaroglu.week_3_homework_2.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpFragment : Fragment() {
    private lateinit var signUpBinding: FragmentSignUpBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        signUpBinding = FragmentSignUpBinding.inflate(inflater)
        return signUpBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signUpButtonClick()
    }

    /**
     *  İlk etapta Edittexlerin boş olup olmadığı kontrol ediliyor.
     *  Daha önce girilen mail adresi ile kayıt var mı kontrol ediliyor.
     *  Herşey uygunsa Firabase database e kayıt yapılarak HomeFragment a yönlendiliyor.
     */
    private fun signUpButtonClick() {
        signUpBinding.signUpButton.setOnClickListener {
            val email = signUpBinding.editTextTextEmailAddress.text.toString()
            val password = signUpBinding.editTextTextPassword.text.toString()

            if (email == "" || password == "") {
                Toast.makeText(context, "Enter email and password!", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                    findNavController().navigate(R.id.action_signUpFragment_to_home_graph)
                }.addOnFailureListener {
                   if(password.length <= 6){
                        Toast.makeText(context, "Lütfen 6 Karakterden Uzun Şifre Girin!",
                            Toast.LENGTH_SHORT).show()
                    }else{
                       Toast.makeText(context, "This Email Address Already Exists",
                           Toast.LENGTH_SHORT).show()
                   }
                }
            }
        }
    }

}