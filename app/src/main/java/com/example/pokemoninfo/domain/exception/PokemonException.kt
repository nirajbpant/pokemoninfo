package com.example.pokemoninfo.domain.exception

 open class PokemonException(
    val message : String? = null
){
    class NoConnectionException(message: String) : PokemonException()
    class UnexpectedException(message: String) : PokemonException()
}
