package com.truongdc21.koinv2.di

import com.truongdc21.koinv2.utils.dispatcher.BaseDispatcherProvider
import com.truongdc21.koinv2.utils.dispatcher.DispatcherProvider
import org.koin.dsl.module

val dispatcherModule = module {
    single { provideBaseDispatcherProvider() }
}

fun provideBaseDispatcherProvider(): BaseDispatcherProvider {
    return DispatcherProvider()
}
