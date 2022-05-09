package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rickandmorty.model.episode.Episode
import com.example.rickandmorty.retfofit.RickAndMortyService
import timber.log.Timber

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
        val list = service.getEpisodes(indices)
        Timber.e("EPISODEVIEWMODEL = $list")
        emit(list)
    } as MutableLiveData<List<Episode>>
}