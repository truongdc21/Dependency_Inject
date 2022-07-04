package com.truongdc21.koinv2.base

import com.truongdc21.koinv2.utils.DataResult
import com.truongdc21.koinv2.utils.dispatcher.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository  {

    @IoDispatcher private val dispatcherIo : CoroutineDispatcher = Dispatchers.IO

    protected suspend fun <R> withContextResult(
        dispatcherContextIO: CoroutineContext = dispatcherIo,
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
