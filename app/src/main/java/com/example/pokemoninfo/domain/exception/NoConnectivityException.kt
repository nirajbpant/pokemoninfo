package com.example.pokemoninfo.domain.exception

import android.content.Context
import com.example.pokemoninfo.R

class NoConnectivityException(private val context: Context) : RuntimeException() {

    override val message: String?
        get() = context.getString(R.string.network_error_message)
}