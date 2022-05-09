package com.example.rickandmorty.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.EpisodeActivity
import com.example.rickandmorty.R
import com.example.rickandmorty.model.character.Character
import com.example.rickandmorty.view.adapter.diff.CharacterItemDiffCallback
import com.example.rickandmorty.view.adapter.holder.CharacterViewHolder
import com.google.gson.Gson
import timber.log.Timber

class CharacterAdapter(private val activity: AppCompatActivity) : ListAdapter<Character, RecyclerView.ViewHolder>(
    CharacterItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val charHolder = holder as CharacterViewHolder

        charHolder.name.text = currentList[position].name
        charHolder.gender.text = currentList[position].gender
        Glide.with(activity)
            .asBitmap()
            .load(currentList[position].image)
            .fallback(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(charHolder.image)

        charHolder.itemView.setOnClickListener {
            val serializedCharacter = Gson().toJson(currentList[position])
            Timber.e("SERIALIZED CHARACTER IN ONCLICK = $serializedCharacter")

            activity.startActivity(Intent(activity, EpisodeActivity::class.java)
                .apply { putExtra("CharacterData", serializedCharacter) })
        }
    }
}

