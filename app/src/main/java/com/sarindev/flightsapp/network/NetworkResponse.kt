package com.sarindev.flightsapp.network

sealed class NetworkResponse<T>(
    var data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : NetworkResponse<T>(data)

    class Error<T>(message: String?, data: T? = null) : NetworkResponse<T>(data, message)

    class Loading<T> : NetworkResponse<T>()

}


