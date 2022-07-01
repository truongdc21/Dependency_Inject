package com.truongdc21.koinv2.utils

import java.io.IOException

sealed class DataResult<out R> {

    data class Success <out T> (val data: T): DataResult<T>()

    data class Error(val exception: Exception): DataResult<Nothing>()

    data class NetworkError(val exception: IOException) : DataResult<Nothing>()

}
