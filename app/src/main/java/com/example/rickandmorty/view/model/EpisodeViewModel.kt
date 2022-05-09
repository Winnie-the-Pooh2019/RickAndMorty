package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rickandmorty.model.episode.Episode
import com.example.rickandmorty.retfofit.RickAndMortyService

class EpisodeViewModel(
    private val service: RickAndMortyService, episodes: List<String>) : ViewModel() {

    private val indices: List<Int> = ArrayList<Int>().apply {
        episodes.forEach {
            add(it
                .substring(it
                    .lastIndexOf('/') + 1)
                .toInt())
        }
    }

    val episodes: MutableLiveData<List<Episode>> = liveData {
        emit(service.getEpisodes(indices))
    } as MutableLiveData<List<Episode>>
}