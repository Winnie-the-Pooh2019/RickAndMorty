package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rickandmorty.App
import com.example.rickandmorty.model.episode.Episode
import timber.log.Timber

class EpisodeViewModel(episodes: List<String>) : ViewModel() {

    private val indices: List<Int> = ArrayList<Int>().apply {
        episodes.forEach {
            add(
                it.substring(it.lastIndexOf('/') + 1)
                    .toInt()
            )
        }
    }

    val episodes: MutableLiveData<List<Episode>> = liveData {
        emit(App.repository.getEpisodes(indices) ?: listOf<Episode>().also { Timber.e(IllegalArgumentException()) })
    } as MutableLiveData<List<Episode>>
}