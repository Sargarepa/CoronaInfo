package com.example.coronainfo

import android.app.Application
import com.example.coronainfo.di.mainModule
import com.example.coronainfo.di.repositoriesModule
import com.example.coronainfo.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

class App : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(mainModule, repositoriesModule, viewModelsModule)
        }
    }
}