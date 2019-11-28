package com.example.dagger2.app

import android.app.Application

import com.example.dagger2.di.component.DaggerMyComponent
import com.example.dagger2.di.component.MyComponent
import com.example.dagger2.di.module.SharedPrefModule

class MyApp : Application() {

    lateinit var myComponent: MyComponent
        private set

    override fun onCreate() {
        super.onCreate()

        myComponent = DaggerMyComponent.builder()
                .sharedPrefModule(SharedPrefModule(this))
                .build()

    }
}
