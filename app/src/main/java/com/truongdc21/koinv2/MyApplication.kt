package com.truongdc21.koinv2

import android.app.Application
import com.truongdc21.koinv2.di.DBModule
import com.truongdc21.koinv2.di.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication: Application(), HasAndroidInjector{

    @Inject
    lateinit var  mInject: DispatchingAndroidInjector<Any>
    override fun onCreate() {
        super.onCreate()
        DaggerMainComponent.builder()
            .dBModule(DBModule(this))
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInject
    }
}
