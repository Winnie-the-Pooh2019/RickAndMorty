package com.example.rickandmorty.view.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rickandmorty.model.episode.Episode
import com.example.rickandmorty.retfofit.RickAndMortyRepository
import timber.log.Timber

class EpisodeViewModel(
    private val repository: RickAndMortyRepository, episodes: List<String>
) : ViewModel() {

    private val indices: List<Int> = ArrayList<Int>().apply {
        episodes.forEach {
            add(
                it.substring(it.lastIndexOf('/') + 1)
                    .toInt()
            )
        }
    }

    val episodes: MutableLiveData<List<Episode>> = liveData {
        emit(repository.getEpisodes(indices) ?: listOf<Episode>().also { Timber.e(IllegalArgumentException()) })
    } as MutableLiveData<List<Episode>>
}