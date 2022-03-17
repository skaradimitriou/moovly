package com.stathis.moovly.features.login.login

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.stathis.moovly.R
import com.stathis.moovly.abstraction.MoovlyFragment
import com.stathis.moovly.databinding.FragmentLoginBinding
import com.stathis.moovly.features.home.MainActivity

class LoginFragment : MoovlyFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private lateinit var viewModel : LoginViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun startOps() {
        binding.registerBtn.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

        binding.forgotPasswordBtn.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }

        binding.loginBtn.setOnClickListener {
            val email = binding.emailInputField.text.toString()
            val pass = binding.passInputField.text.toString()

            viewModel.login(email,pass)
        }

        viewModel.loggedIn.observe(viewLifecycleOwner){
            when(it){
                true -> {
                    startActivity(Intent(requireContext(),MainActivity::class.java))
                    requireActivity().finish()
                }
                false -> {} //FIXME: Throw error kebab on top of screen in error data
            }
        }
    }

    override fun stopOps() {
        viewModel.loggedIn.removeObservers(viewLifecycleOwner)
    }
}