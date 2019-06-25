package com.wolvesstudio.example

import android.app.Application
import com.wolvesstudio.example.screens.detail.detailModule
import com.wolvesstudio.example.screens.main.mainModule
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