package com.truongdc21.koinv2.di

import com.truongdc21.koinv2.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component (modules = arrayOf(
    AndroidInjectionModule::class,
    FragmentModule::class,
    CoroutinesDispatchersModule::class ,
    DataSourceModule::class,
    DBModule::class)
)
interface MainComponent {
    fun inject(application: MyApplication )
}

