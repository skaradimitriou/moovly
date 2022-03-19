package com.stathis.moovly.features.login.register

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.stathis.moovly.R
import com.stathis.moovly.abstraction.MoovlyFragment
import com.stathis.moovly.databinding.FragmentRegisterBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
                true -> accountCreated()
                false -> Toast.makeText(requireContext(),getString(R.string.error),Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun stopOps() {
        viewModel.accountCreated.removeObservers(viewLifecycleOwner)
    }

    private fun accountCreated(){
        Toast.makeText(requireContext(),getString(R.string.account_created),Toast.LENGTH_LONG).show()
        lifecycleScope.launch {
            findNavController().navigate(R.id.loginFragment)
            delay(2000)
        }
    }
}