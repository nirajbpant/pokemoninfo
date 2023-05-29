package com.example.pokemoninfo.domain.repository

import arrow.core.Either
import com.example.pokemoninfo.data.models.PokemonResponse
import com.example.pokemoninfo.domain.exception.PokemonException

interface IPokemonRepository {

    suspend fun getAllPokemons() : Either<PokemonResponse, PokemonException>
}