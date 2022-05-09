package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.retfofit.RickAndMortyRepository
import com.example.rickandmorty.retfofit.RickAndMortyService

class App : Application() {
    companion object {
        val repository: RickAndMortyRepository by lazy {
            RickAndMortyRepository(RickAndMortyService.getInstance())
        }
    }
}