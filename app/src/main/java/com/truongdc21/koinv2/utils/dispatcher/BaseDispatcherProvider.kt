package com.truongdc21.koinv2.utils.dispatcher

import androidx.annotation.NonNull
import kotlinx.coroutines.CoroutineDispatcher

interface BaseDispatcherProvider {

    @NonNull
    fun default(): CoroutineDispatcher

    @NonNull
    fun io(): CoroutineDispatcher

    @NonNull
    fun ui(): CoroutineDispatcher

    @NonNull
    fun unconfined(): CoroutineDispatcher
}
