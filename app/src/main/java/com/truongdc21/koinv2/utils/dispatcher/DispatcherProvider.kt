package com.truongdc21.koinv2.utils.dispatcher

import androidx.annotation.NonNull
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherProvider : BaseDispatcherProvider {

    @NonNull
    override fun default(): CoroutineDispatcher = Dispatchers.Default

    @NonNull
    override fun io(): CoroutineDispatcher = Dispatchers.IO

    @NonNull
    override fun ui(): CoroutineDispatcher = Dispatchers.Main

    @NonNull
    override fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined

}
