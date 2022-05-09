package com.example.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.retfofit.RickAndMortyRepository
import com.example.rickandmorty.retfofit.RickAndMortyService
import com.example.rickandmorty.view.adapter.CharacterAdapter
import com.example.rickandmorty.view.model.CharacterViewModel
import com.example.rickandmorty.view.model.factory.ViewModelFactory
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val model: CharacterViewModel by ViewModelFactory.viewModelFactory(this) {
        CharacterViewModel(
            RickAndMortyRepository(RickAndMortyService.getInstance())
        ).apply(CharacterViewModel::load)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        findViewById<RecyclerView>(R.id.main_recycler).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CharacterAdapter(this@MainActivity, model).apply {
                model.characters.observe(this@MainActivity) { this.submitList(it) }
            }
        }
    }
}