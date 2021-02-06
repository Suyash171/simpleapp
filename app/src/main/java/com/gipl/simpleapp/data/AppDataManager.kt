package com.gipl.simpleapp.data

import android.content.Context
import com.gipl.simpleapp.data.pref.AppPrefManager

class AppDataManager(val context: Context) : IDataManager {
    private var mPref: AppPrefManager = AppPrefManager(context, "PREF")
    
}