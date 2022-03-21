package com.stathis.moovly.features.login.result

import androidx.navigation.fragment.findNavController
import com.stathis.moovly.R
import com.stathis.moovly.abstraction.MoovlyFragment
import com.stathis.moovly.databinding.FragmentResultBinding


class ResultFragment : MoovlyFragment<FragmentResultBinding>(R.layout.fragment_result) {

    override fun init() {}

    override fun startOps() {
        binding.getStartedBtn.setOnClickListener {
            findNavController().navigate(R.id.goToLogin)
        }
    }

    override fun stopOps() {}
}