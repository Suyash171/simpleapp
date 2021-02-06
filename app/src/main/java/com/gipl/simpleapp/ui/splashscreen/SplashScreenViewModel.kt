package com.gipl.simpleapp.ui.splashscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gipl.simpleapp.models.Response
import com.google.firebase.auth.FirebaseAuth

class SplashScreenViewModel : ViewModel() {
   // private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val mutableLiveData: MutableLiveData<Response> = MutableLiveData()

    fun checkPreviousLogin() {
        Thread {
            kotlin.run {
                Thread.sleep(2000)
                //if (auth.currentUser != null && auth.currentUser!!.isEmailVerified) {
                    mutableLiveData.postValue(Response.success(true))
                /*} else {
                    mutableLiveData.postValue(Response.success(false))
                }*/
            }
        }.start()
    }

}