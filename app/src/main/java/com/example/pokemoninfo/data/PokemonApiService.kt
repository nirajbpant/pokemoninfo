package com.example.pokemoninfo.data

import com.example.pokemoninfo.data.models.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApiService {

    @GET("/pokemon")
    suspend fun getPokemons(): Response<PokemonResponse>
}