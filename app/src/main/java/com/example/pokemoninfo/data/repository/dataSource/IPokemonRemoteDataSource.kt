package com.example.pokemoninfo.data.repository.dataSource

import com.example.pokemoninfo.core.DataResult
import com.example.pokemoninfo.data.models.PokemonResponse

interface IPokemonRemoteDataSource {

    suspend fun getPokemons() : PokemonResponse
}