package com.stathis.moovly.features.login.forgotpass

import androidx.lifecycle.ViewModelProvider
import com.stathis.moovly.R
import com.stathis.moovly.abstraction.MoovlyFragment
import com.stathis.moovly.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : MoovlyFragment<FragmentForgotPasswordBinding>(R.layout.fragment_forgot_password) {

    private lateinit var viewModel : ForgotPassViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(ForgotPassViewModel::class.java)
    }

    override fun startOps() {
        binding.sendActivationEmail.setOnClickListener {
            val email = binding.forgotEmailField.text.toString()
            viewModel.sendVerificationEmail(email)
        }

        viewModel.emailSent.observe(viewLifecycleOwner){
            when(it){
                true -> {}
                false -> {}
            }
        }
    }

    override fun stopOps() {
        viewModel.emailSent.removeObservers(viewLifecycleOwner)
    }
}