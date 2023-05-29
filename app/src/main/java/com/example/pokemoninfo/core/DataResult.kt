package com.example.pokemoninfo.core

import java.io.Serializable

open class DataResult<T>(
    var data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : DataResult<T>(data)
    class Loading<T>(data: T? = null) : DataResult<T>(data)
    class Error<T>(message: String, data: T? = null) : DataResult<T>(data, message)


    enum class Status{
        SUCCESS,
        ERROR,
        LOADING,
    }
}

