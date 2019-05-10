package com.example.myapplication.Utils

import android.app.Application
import android.content.Context

class MainClass: Application() {

    private var myContext:Context? =null

    override fun onCreate() {
        super.onCreate()
        myContext = applicationContext
    }

    fun getAppContext(): Context? {
        return myContext
    }


}