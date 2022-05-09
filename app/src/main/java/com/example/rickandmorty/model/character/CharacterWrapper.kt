package com.example.rickandmorty.model.character

data class CharacterWrapper(
    val info: CharacterInfo,
    val results: List<Character>
)
