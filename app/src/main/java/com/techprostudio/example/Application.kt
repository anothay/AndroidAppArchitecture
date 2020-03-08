package com.techprostudio.example

import android.app.Application
import com.techprostudio.example.baseModule
import com.techprostudio.example.screens.detail.detailModule
import com.techprostudio.example.screens.main.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CurrentApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CurrentApplication)
            modules(baseModule, detailModule, mainModule)
        }
    }

}