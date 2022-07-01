package com.truongdc21.koinv2

import android.app.Application
import com.truongdc21.koinv2.di.DatabaseModule
import com.truongdc21.koinv2.di.AppModule
import com.truongdc21.koinv2.di.RepositoryModule

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class MyApplication: Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(AppModule().module, DatabaseModule().module, RepositoryModule().module))
        }
    }
}
