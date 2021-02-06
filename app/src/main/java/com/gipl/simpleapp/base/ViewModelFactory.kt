package com.gipl.simpleapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gipl.simpleapp.data.IDataManager
import com.gipl.simpleapp.ui.home.HomeViewModel
import com.gipl.simpleapp.ui.splashscreen.SplashScreenViewModel
import com.tapcom.expensemanager.ui.login.LoginViewModel

object ViewModelFactory : ViewModelProvider.Factory {
    private lateinit var dataManager: IDataManager;

    fun inject(dataManager: IDataManager) {
        this.dataManager = dataManager
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.simpleName.equals(SplashScreenViewModel::class.simpleName)){
            return SplashScreenViewModel() as T
        }
        if (modelClass.simpleName.equals(LoginViewModel::class.simpleName)) {
            return LoginViewModel() as T
        }
        if (modelClass.simpleName.equals(HomeViewModel::class.simpleName)){
            return HomeViewModel() as T
        }
        /*if (modelClass.simpleName.equals(RegisterUserViewModel::class.simpleName)){
            return RegisterUserViewModel() as T
        }*/

        return null as T
    }
}