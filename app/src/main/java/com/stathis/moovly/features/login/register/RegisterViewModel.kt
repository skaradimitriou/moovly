package com.stathis.moovly.features.login.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    val accountCreated = MutableLiveData<Boolean>()
    private val auth by lazy { FirebaseAuth.getInstance() }

    fun createAccount(email: String, pass: String, passConfirm: String) {
        when(pass == passConfirm){
            true -> registerUser(email,pass)
            false -> accountCreated.postValue(false)
        }
    }

    private fun registerUser(email: String, pass: String) {
        viewModelScope.launch(Dispatchers.IO) {
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                when (it.isSuccessful) {
                    true -> accountCreated.postValue(true)
                    false -> accountCreated.postValue(false)
                }
            }
        }
    }
}