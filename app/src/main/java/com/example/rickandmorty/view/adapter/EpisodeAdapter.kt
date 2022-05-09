package com.example.rickandmorty.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.model.episode.Episode
import com.example.rickandmorty.view.adapter.diff.EpisodeItemDiffCallback
import com.example.rickandmorty.view.adapter.holder.EpisodeViewHolder

class EpisodeAdapter : ListAdapter<Episode, RecyclerView.ViewHolder>(
    EpisodeItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EpisodeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_episodes, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val epHolder = holder as EpisodeViewHolder

        epHolder.date.text = currentList[position].airDate
        epHolder.name.text = currentList[position].name
    }
}