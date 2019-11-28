package com.example.dagger2.di.module


import android.content.Context
import android.content.SharedPreferences

import javax.inject.Singleton

import dagger.Module
import dagger.Provides


/**
 * @author Akash Garg
 */


@Module
class SharedPrefModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }


    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("MyAppPref", Context.MODE_PRIVATE)
    }


}
