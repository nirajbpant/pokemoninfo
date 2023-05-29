package com.example.pokemoninfo.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemoninfo.core.DataResult
import com.example.pokemoninfo.data.models.PokemonResponse
import com.example.pokemoninfo.domain.usecase.GetAllPokemonsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase
) : ViewModel() {

    private val pokemons : MutableLiveData<DataResult<PokemonResponse>> = MutableLiveData()

    fun getPokemons() = viewModelScope.launch(Dispatchers.IO) {
        pokemons.postValue(DataResult())
        val pokemonResponse = getAllPokemonsUseCase.execute()
        pokemonResponse.fold({data -> pokemons.postValue(DataResult(data = data, message = null ))},
            { exception ->pokemons.postValue(DataResult(data = null, message = exception.message))})
    }
}