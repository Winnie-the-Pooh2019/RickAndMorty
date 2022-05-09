package com.example.rickandmorty.view.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.model.character.Character

class CharacterItemDiffCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Character, newItem: Character) =
        oldItem == newItem
}