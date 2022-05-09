package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rickandmorty.retfofit.RickAndMortyService

import com.example.rickandmorty.model.character.Character
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import timber.log.Timber

class CharacterViewModel(private val service: RickAndMortyService) : ViewModel() {
    private val page: Int = 1

    val characters: MutableLiveData<List<Character>> = liveData {
        val data = service.getCharacters(page).results
        emit(data)
    } as MutableLiveData<List<Character>>
}