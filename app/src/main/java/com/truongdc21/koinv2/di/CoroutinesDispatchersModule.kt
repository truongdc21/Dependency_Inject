package com.truongdc21.koinv2.di

import com.truongdc21.koinv2.utils.dispatcher.DefaultDispatcher
import com.truongdc21.koinv2.utils.dispatcher.IoDispatcher
import com.truongdc21.koinv2.utils.dispatcher.MainDispatcher
import com.truongdc21.koinv2.utils.dispatcher.UnconfinedDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class CoroutinesDispatchersModule {

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @UnconfinedDispatcher
    @Provides
    fun providesMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined
}
