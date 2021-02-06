package com.gipl.simpleapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gipl.simpleapp.models.Response

class HomeViewModel : ViewModel(){
    val mutableLiveData: MutableLiveData<Response> = MutableLiveData()
}