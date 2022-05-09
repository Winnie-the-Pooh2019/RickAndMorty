package com.example.rickandmorty.retfofit

import com.example.rickandmorty.model.character.CharacterWrapper
import com.example.rickandmorty.model.episode.Episode
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character?")
    suspend fun getCharacters(@Query("page") pageId: Int): Response<CharacterWrapper>

    @GET("episode/{id}")
    suspend fun getEpisodes(@Path("id") idList: List<Int>): Response<List<Episode>>

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"

        fun getInstance(): RickAndMortyService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient
                    .Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BASIC) })
                    .build()
            )
            .build()
            .create(RickAndMortyService::class.java)
    }
}