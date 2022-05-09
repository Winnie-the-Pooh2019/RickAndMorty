package com.example.rickandmorty.retfofit

import com.example.rickandmorty.model.character.Character

class RickRepository(private val service: RickAndMortyService) {
    suspend fun getCharacters(pageId: Int): List<Character> {
        return listOf()
    }
}