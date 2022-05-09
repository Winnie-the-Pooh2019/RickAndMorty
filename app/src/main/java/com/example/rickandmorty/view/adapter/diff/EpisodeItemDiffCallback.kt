package com.example.rickandmorty.view.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.model.episode.Episode

class EpisodeItemDiffCallback : DiffUtil.ItemCallback<Episode>() {
    override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean =
        oldItem == newItem
}