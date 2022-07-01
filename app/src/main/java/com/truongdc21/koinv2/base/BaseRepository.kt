package com.truongdc21.koinv2.base

import com.truongdc21.koinv2.utils.DataResult
import com.truongdc21.koinv2.utils.dispatcher.BaseDispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import java.io.IOException
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository : KoinComponent {
    private val dispatcherProvider = get<BaseDispatcherProvider>()

    protected suspend fun <R> withContextResult(
        dispatcherContextIO: CoroutineContext = dispatcherProvider.io(),
        requestBlock: suspend CoroutineScope.() -> R
    ): DataResult<R> = withContext(dispatcherContextIO) {
        return@withContext try {
            val response = requestBlock()
            DataResult.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            DataResult.Error(e)
        } catch (e : IOException){
            e.printStackTrace()
            DataResult.NetworkError(e)
        }
    }
}

