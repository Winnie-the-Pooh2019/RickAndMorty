package com.example.rickandmorty.model.episode

import com.google.gson.annotations.SerializedName

data class Episode (
    val name: String,
    @SerializedName("air_date") val airDate: String,
)
