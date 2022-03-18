package com.stathis.moovly.features.login.register

import androidx.lifecycle.ViewModelProvider
import com.stathis.moovly.R
import com.stathis.moovly.abstraction.MoovlyFragment
import com.stathis.moovly.databinding.FragmentRegisterBinding

class RegisterFragment : MoovlyFragment<FragmentRegisterBinding>(R.layout.fragment_register) {

    private lateinit var viewModel : RegisterViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun startOps() {
        binding.registerBtn.setOnClickListener {
            val email = binding.emailInputField.text.toString()
            val pass = binding.passInputField.text.toString()
            val passConfirm = binding.passConfInputField.text.toString()
            viewModel.createAccount(email,pass, passConfirm)
        }

        viewModel.accountCreated.observe(viewLifecycleOwner){
            when(it){
                true -> {}
                false -> {}
            }
        }
    }

    override fun stopOps() {
        viewModel.accountCreated.removeObservers(viewLifecycleOwner)
    }
}