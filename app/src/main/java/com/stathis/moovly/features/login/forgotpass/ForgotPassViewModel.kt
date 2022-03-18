package com.stathis.moovly.features.login.forgotpass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ForgotPassViewModel : ViewModel() {

    val emailSent = MutableLiveData<Boolean>()

    fun sendVerificationEmail(email : String){
        viewModelScope.launch(Dispatchers.IO){
            emailSent.postValue(true)
            delay(2000)
        }
    }
}