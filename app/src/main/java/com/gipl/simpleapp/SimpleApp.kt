package com.gipl.simpleapp

import android.app.Application
import com.gipl.simpleapp.base.ViewModelFactory
import com.gipl.simpleapp.data.AppDataManager
import com.gipl.simpleapp.data.IDataManager

class SimpleApp : Application(){
    override fun onCreate() {
        super.onCreate()
        val dataManager: IDataManager = AppDataManager(applicationContext)
        ViewModelFactory.inject(dataManager)
    }
}