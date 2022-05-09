package com.example.rickandmorty.model.character

data class Character(
    val name: String,
    val gender: String,
    val origin: Origin,
    val image: String,
    val episode: List<String>,
) : CharacterAdapterItem
