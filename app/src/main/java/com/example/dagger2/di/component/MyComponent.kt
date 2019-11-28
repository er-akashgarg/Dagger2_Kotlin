package com.example.dagger2.di.component


import com.example.dagger2.activity.MainActivity
import com.example.dagger2.di.module.SharedPrefModule

import javax.inject.Singleton

import dagger.Component


/**
 * @author Akash Garg
 */


@Singleton
@Component(modules = [SharedPrefModule::class])
interface MyComponent {

   fun inject(activity: MainActivity)

}
