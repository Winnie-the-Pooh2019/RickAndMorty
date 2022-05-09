package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.App
import com.example.rickandmorty.model.episode.Episode

class EpisodeViewModel(episodes: List<String>) : ViewModel() {

    private val indices: List<Int> = ArrayList<Int>().apply {
        episodes.forEach {
            add(
                it.substring(it.lastIndexOf('/') + 1)
                    .toInt()
            )
        }
    }

    val episodes: MutableLiveData<List<Episode>> = MutableLiveData()

    suspend fun load(): Boolean {
        val data = App.repository.getEpisodes(indices)

        if (data != null)
            episodes.postValue(data!!)

        return data != null
    }
}