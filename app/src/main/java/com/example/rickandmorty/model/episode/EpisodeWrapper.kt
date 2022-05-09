package com.example.rickandmorty.model.episode

data class EpisodeWrapper(
    val info: EpisodeInfo,
    val results: List<Episode>
)
