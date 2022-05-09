package com.example.rickandmorty.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.rickandmorty.EpisodeActivity
import com.example.rickandmorty.R
import com.example.rickandmorty.model.character.Character
import com.example.rickandmorty.model.character.CharacterAdapterItem
import com.example.rickandmorty.model.character.CharacterInfo
import com.example.rickandmorty.view.adapter.diff.CharacterItemDiffCallback
import com.example.rickandmorty.view.adapter.holder.ButtonViewHolder
import com.example.rickandmorty.view.adapter.holder.CharacterViewHolder
import com.example.rickandmorty.view.adapter.holder.Holder
import com.example.rickandmorty.view.model.CharacterViewModel
import com.google.gson.Gson
import timber.log.Timber

class CharacterAdapter(private val activity: AppCompatActivity, val model: CharacterViewModel) :
    ListAdapter<CharacterAdapterItem, Holder>(
        CharacterItemDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return when (viewType) {
            R.layout.recycler_main -> CharacterViewHolder(
                LayoutInflater.from(parent.context).inflate(viewType, parent, false)
            )
            R.layout.recycler_controls -> ButtonViewHolder(
                LayoutInflater.from(parent.context).inflate(viewType, parent, false)
            )
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Character -> R.layout.recycler_main
            is CharacterInfo -> R.layout.recycler_controls
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        when (holder) {
            is CharacterViewHolder -> {
                val character = currentList[position] as Character
                
                holder.name.text = (character).name
                holder.gender.text = (character).gender
                Glide.with(activity)
                    .asBitmap()
                    .load((character).image)
                    .fallback(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.image)

                holder.itemView.setOnClickListener {
                    val serializedCharacter = Gson().toJson(currentList[position])
                    Timber.e("SERIALIZED CHARACTER IN ONCLICK = $serializedCharacter")

                    activity.startActivity(Intent(activity, EpisodeActivity::class.java)
                        .apply { putExtra("CharacterData", serializedCharacter) })
                }
            }
            is ButtonViewHolder -> {
                holder.more.setOnClickListener {
                    if ((currentList[position] as CharacterInfo).next != null)
                        model.load()
                }
            }
        }
    }
}

