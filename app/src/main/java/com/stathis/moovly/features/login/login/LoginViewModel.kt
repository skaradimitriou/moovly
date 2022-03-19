package com.stathis.moovly.features.login.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loggedIn = MutableLiveData<Boolean>()
    private val auth by lazy { FirebaseAuth.getInstance() }

    fun login(email : String, pass : String){
        viewModelScope.launch(Dispatchers.IO){
            auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                when(it.isSuccessful){
                    true -> loggedIn.postValue(true)
                    false -> loggedIn.postValue(false)
                }
            }
        }
    }
}