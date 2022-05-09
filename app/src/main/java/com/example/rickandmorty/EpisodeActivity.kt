package com.example.rickandmorty

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.model.character.Character
import com.example.rickandmorty.retfofit.RickAndMortyRepository
import com.example.rickandmorty.retfofit.RickAndMortyService
import com.example.rickandmorty.view.adapter.EpisodeAdapter
import com.example.rickandmorty.view.model.EpisodeViewModel
import com.example.rickandmorty.view.model.factory.ViewModelFactory
import com.google.gson.Gson

class EpisodeActivity : AppCompatActivity() {

    private val character: Character by lazy {
        Gson().fromJson(
            intent.getStringExtra("CharacterData"), Character::class.java
        )
    }

    private val model: EpisodeViewModel by ViewModelFactory.viewModelFactory(this) {
        EpisodeViewModel(
            RickAndMortyRepository(RickAndMortyService.getInstance()),
            character.episode
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodes)

        Glide.with(this)
            .asBitmap()
            .load(character.image)
            .fallback(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(findViewById(R.id.details_image))

        findViewById<TextView>(R.id.details_name).text = character.name
        findViewById<TextView>(R.id.details_origin).text =
            getString(R.string.details_origin_text, character.origin.name)
        findViewById<TextView>(R.id.details_mariage).text =
            getString(R.string.details_mariage_text, if (character.gender == "Male") "Not married" else "Single")

        findViewById<RecyclerView>(R.id.episodes_recycler).apply {
            layoutManager = LinearLayoutManager(this@EpisodeActivity)
            adapter = EpisodeAdapter().apply {
                model.episodes.observe(this@EpisodeActivity) { this.submitList(it) }
            }
        }
    }
}