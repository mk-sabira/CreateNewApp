package com.example.mycryptoapp.common

import android.app.Application
import com.example.mycryptoapp.di.AppComponent
import com.example.mycryptoapp.di.AppModule
import com.example.mycryptoapp.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

}