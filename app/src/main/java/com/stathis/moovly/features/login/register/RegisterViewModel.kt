package com.stathis.moovly.features.login.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    val accountCreated = MutableLiveData<Boolean>()

    fun createAccount(email : String, pass : String, passConfirm : String){
        viewModelScope.launch(Dispatchers.IO){
            accountCreated.postValue(true)
            delay(2000)
        }
    }
}