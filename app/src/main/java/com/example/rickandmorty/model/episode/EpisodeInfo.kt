package com.example.rickandmorty.model.episode

data class EpisodeInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
