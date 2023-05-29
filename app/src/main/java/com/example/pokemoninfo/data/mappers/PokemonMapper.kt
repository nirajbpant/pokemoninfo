package com.example.pokemoninfo.data.mappers

import com.example.pokemoninfo.data.models.PokemonResponse
import com.example.pokemoninfo.data.utils.Resource
import retrofit2.Response

class PokemonMapper {

     fun responseToResource(response: Response<PokemonResponse>) : Resource<PokemonResponse> {
        if(response.isSuccessful){
            response.body()?.let {
                    result-> return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}