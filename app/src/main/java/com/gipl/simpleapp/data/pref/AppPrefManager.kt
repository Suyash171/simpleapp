package com.gipl.simpleapp.data.pref

import android.content.Context
import android.content.SharedPreferences

class AppPrefManager(private val context: Context, private val prefName: String) {
    val pref: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

}