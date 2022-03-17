package com.stathis.moovly.features.login.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loggedIn = MutableLiveData<Boolean>()

    fun login(email : String, pass : String){
        viewModelScope.launch(Dispatchers.IO){
            val checkCredentials = email == "admin@gmail.com" && pass == "Test1234!"
            delay(2000)
            loggedIn.postValue(checkCredentials)
        }
    }
}