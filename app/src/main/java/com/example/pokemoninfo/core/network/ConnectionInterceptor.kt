package com.example.pokemoninfo.core.network

import android.content.Context
import com.example.pokemoninfo.core.isConnected
import com.example.pokemoninfo.domain.exception.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectionInterceptor(private val context : Context ) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        context.isConnected.let {
            if(it) chain.proceed(chain.request())
            else throw NoConnectivityException(context)
        }
}