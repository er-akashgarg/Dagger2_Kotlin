package com.example.dagger2.utils

import android.content.SharedPreferences

import javax.inject.Inject


/**
 * @author Akash Garg
 */

open class MySharedPreference
@Inject
constructor(val preferences: SharedPreferences) {

    fun putData(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun getData(key: String): String? {
        return preferences.getString(key, "default")
    }
}
