package com.stathis.moovly.features.login

import com.stathis.moovly.R
import com.stathis.moovly.abstraction.MoovlyActivity
import com.stathis.moovly.databinding.ActivityLoginBinding

class LoginActivity : MoovlyActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun init() {
        supportActionBar?.hide()
    }

    override fun startOps() {}

    override fun stopOps() {}

    override fun onBackPressed() {
        super.onBackPressed()
    }
}