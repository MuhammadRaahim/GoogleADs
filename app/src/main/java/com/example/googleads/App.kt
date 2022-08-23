package com.example.googleads

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.ads.MobileAds

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        context = applicationContext
        MobileAds.initialize(this)
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        fun getAppContext(): Context? {
            return context
        }
    }
}