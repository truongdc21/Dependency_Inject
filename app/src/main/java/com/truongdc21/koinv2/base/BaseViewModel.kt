package com.truongdc21.koinv2.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.truongdc21.koinv2.utils.DataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.IOException

abstract class BaseViewModel : ViewModel() {

    protected fun <T>launchTaskSync(
        onRequest : suspend CoroutineScope.() -> DataResult<T>,
        onSuccess : (T) -> Unit = {} ,
        onError : (Exception) -> Unit = {} ,
        onNetWorkError : (IOException) -> Unit = {}

    )= viewModelScope.launch{

        when (val asynchronousTasks = onRequest(this)) {

            is DataResult.Success -> {
                onSuccess(asynchronousTasks.data)
            }

            is DataResult.Error -> {
                onError(asynchronousTasks.exception)
            }

            is DataResult.NetworkError -> {
                onNetWorkError(asynchronousTasks.exception)
            }
        }
    }
}
