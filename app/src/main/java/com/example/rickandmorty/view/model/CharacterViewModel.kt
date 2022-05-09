package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.App
import com.example.rickandmorty.model.character.CharacterAdapterItem
import timber.log.Timber

class CharacterViewModel : ViewModel() {
    private var page: Int = 1

    val characters: MutableLiveData<MutableList<CharacterAdapterItem>> = MutableLiveData()

    suspend fun load(): Boolean  {
        Timber.e("IN LOAD FUNCTION")
        val data = App.repository.getCharacters(page)

        if (data != null) {
            characters.postValue(characters.value?.let {
                val copy = ArrayList(it)
                copy.removeAt(copy.size - 1)
                copy.addAll(data.results)
                copy.add(data.info)

                return@let copy
            } ?: data.results.toMutableList<CharacterAdapterItem>()
                .apply { if (data.info.next != null) add(data.info) })
            page++
        }

        return data != null
    }
}