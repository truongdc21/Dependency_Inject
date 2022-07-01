package com.truongdc21.koinv2

import android.app.Application
import com.truongdc21.koinv2.di.*
import com.truongdc21.koinv2.test.testModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class MyApplication: Application() {

    private val rootModule  = listOf(
        dispatcherModule,
        ViewModelModule,
        databseModule,
        repositoryModule,
        testModule
    )
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(rootModule)
        }
    }
}
