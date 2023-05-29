package com.example.pokemoninfo.data.repository

import arrow.core.Either
import com.example.pokemoninfo.data.mappers.PokemonMapper
import com.example.pokemoninfo.data.models.PokemonResponse
import com.example.pokemoninfo.data.repository.dataSource.IPokemonRemoteDataSource
import com.example.pokemoninfo.domain.exception.PokemonException
import com.example.pokemoninfo.domain.repository.IPokemonRepository

class PokemonRepositoryImpl(private val pokemonRemoteDataSource: IPokemonRemoteDataSource):IPokemonRepository {
    private val pokemonMapper by lazy { PokemonMapper() }

    override suspend fun getAllPokemons(): Either<PokemonResponse, PokemonException> {
        return try {
            return Either.Left(pokemonRemoteDataSource.getPokemons())
        } catch (e: RuntimeException) {
            return Either.Right(PokemonException(message = e.message))
        }
    }


}