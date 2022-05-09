package com.example.rickandmorty.model.character

data class CharacterInfo(
    val next: String?,
    val prev: String?
) : CharacterAdapterItem
