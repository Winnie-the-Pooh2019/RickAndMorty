package com.example.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.model.character.Character
import com.example.rickandmorty.retfofit.RetrofitBuilder
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
            RetrofitBuilder.service,
            character.episode
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodes)
        supportActionBar!!.title = character.name

        findViewById<RecyclerView>(R.id.episodes_recycler).apply {
            layoutManager = LinearLayoutManager(this@EpisodeActivity)
            adapter = EpisodeAdapter().apply {
                model.episodes.observe(this@EpisodeActivity) { this.submitList(it) }
            }
        }
    }
}