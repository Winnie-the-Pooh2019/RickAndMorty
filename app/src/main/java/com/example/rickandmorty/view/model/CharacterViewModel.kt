package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.model.character.CharacterAdapterItem
import com.example.rickandmorty.retfofit.RickAndMortyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class CharacterViewModel(private val repository: RickAndMortyRepository) : ViewModel() {
    private var page: Int = 1

    val characters: MutableLiveData<MutableList<CharacterAdapterItem>> = MutableLiveData()

    fun load() = CoroutineScope(Dispatchers.Main).launch {
        val data = repository.getCharacters(page)

        if (data != null)
            characters.postValue(characters.value?.let {
                val copy = ArrayList(it)
                copy.removeAt(copy.size - 1)
                copy.addAll(data.results)
                copy.add(data.info)

                return@let copy
            } ?: data.results.toMutableList<CharacterAdapterItem>()
                .apply { if (data.info.next != null) add(data.info) })
        else
            Timber.e(IllegalArgumentException())

        page++
    }
}