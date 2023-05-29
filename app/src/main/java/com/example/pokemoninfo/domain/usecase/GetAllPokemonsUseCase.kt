package com.example.pokemoninfo.domain.usecase

import arrow.core.Either
import com.example.pokemoninfo.data.models.PokemonResponse
import com.example.pokemoninfo.domain.exception.PokemonException
import com.example.pokemoninfo.domain.repository.IPokemonRepository

class GetAllPokemonsUseCase(private val pokemonRepository: IPokemonRepository) {

    suspend fun execute() : Either<PokemonResponse, PokemonException> {
        return pokemonRepository.getAllPokemons()
    }
}