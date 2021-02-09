package com.gipl.simpleapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gipl.simpleapp.Utility.Resource
import com.gipl.simpleapp.data.api.ApiHelper
import com.gipl.simpleapp.data.api.ApiHelperImpl
import com.gipl.simpleapp.data.api.ApiService
import com.gipl.simpleapp.data.api.RetrofitBuilder
import com.gipl.simpleapp.models.ApiUser
import com.gipl.simpleapp.models.Response
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val mutableLiveData: MutableLiveData<Response> = MutableLiveData()
    private val users = MutableLiveData<Resource<List<ApiUser>>>()
    private var apiHelper : ApiHelper = ApiHelperImpl(RetrofitBuilder.apiService);

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val usersFromApi = apiHelper.getUsers()
                users.postValue(Resource.success(usersFromApi))
            } catch (e: Exception) {
                users.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<List<ApiUser>>> {
        return users
    }
}