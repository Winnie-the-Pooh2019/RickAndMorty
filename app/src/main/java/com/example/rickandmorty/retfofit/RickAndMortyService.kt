package com.example.rickandmorty.retfofit

import com.example.rickandmorty.model.character.CharacterWrapper
import com.example.rickandmorty.model.episode.Episode
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character?")
    suspend fun getCharacters(@Query("page") pageId: Int = 1): CharacterWrapper

    @GET("episode/{id}")
    suspend fun getEpisodes(@Path("id") idList: List<Int>): List<Episode>
}