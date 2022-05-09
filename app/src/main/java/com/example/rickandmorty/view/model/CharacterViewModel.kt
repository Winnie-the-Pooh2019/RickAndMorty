package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.model.character.CharacterAdapterItem
import com.example.rickandmorty.retfofit.RickAndMortyService
import kotlinx.coroutines.runBlocking

class CharacterViewModel(private val service: RickAndMortyService) : ViewModel() {
    private var page: Int = 1

    val characters: MutableLiveData<MutableList<CharacterAdapterItem>> = MutableLiveData()

    fun load(): Unit = runBlocking {
        val data = service.getCharacters(page)

        characters.value = characters.value?.let {
            val copy = ArrayList(it)
            copy.removeAt(copy.size - 1)
            copy.addAll(data.results)
            copy.add(data.info)

            return@let copy
        } ?: data.results.toMutableList<CharacterAdapterItem>().apply { if (data.info.next != null) add(data.info) }

        page++
    }
}