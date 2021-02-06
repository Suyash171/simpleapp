package com.tapcom.expensemanager.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gipl.simpleapp.R
import com.gipl.simpleapp.models.Response

class LoginViewModel : ViewModel() {
   // private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val mutableLiveData: MutableLiveData<Response> = MutableLiveData()

    fun login(userName: String, password: String) {
        mutableLiveData.value = Response.loading(R.string.msg_default_wait)
       // firebaseAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener {
            //if (it.isSuccessful) {
              //  if (firebaseAuth.currentUser != null && firebaseAuth.currentUser!!.isEmailVerified)
        mutableLiveData.value = Response.success(true)
                //else
                  //  mutableLiveData.value = Response.error(CustomException("User is not verify"))
           /* } else {
                mutableLiveData.value = Response.error(it.exception)
            }*/
       // }
    }
}