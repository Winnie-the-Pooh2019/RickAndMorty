package com.example.rickandmorty.retfofit

import com.example.rickandmorty.model.character.CharacterWrapper
import com.example.rickandmorty.model.episode.Episode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RickAndMortyRepository(private val service: RickAndMortyService) {
    suspend fun getCharacters(page: Int): CharacterWrapper? = withContext(Dispatchers.IO) {
        val response = service.getCharacters(page)

        return@withContext if (response.isSuccessful)
            response.body()
        else null
    }

    suspend fun getEpisodes(idList: List<Int>): List<Episode>? = withContext(Dispatchers.IO) {
        val response = service.getEpisodes(idList)

        return@withContext if (response.isSuccessful)
            response.body()
        else null
    }
}