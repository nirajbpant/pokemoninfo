package com.example.pokemoninfo.data.repository.dataSourceImpl

import com.example.pokemoninfo.core.DataResult
import com.example.pokemoninfo.data.PokemonApiService
import com.example.pokemoninfo.data.mappers.PokemonMapper
import com.example.pokemoninfo.data.models.PokemonResponse
import com.example.pokemoninfo.data.repository.dataSource.IPokemonRemoteDataSource

class PokemonRemoteDataSourceImpl(private val pokemonApiService: PokemonApiService) : IPokemonRemoteDataSource {
    private val pokemonMapper by lazy { PokemonMapper() }

    override suspend fun getPokemons(): PokemonResponse {
        return pokemonMapper.responseToResource(pokemonApiService.getPokemons())
    }
}