package com.example.rickandmorty.view.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.model.character.CharacterAdapterItem

class CharacterItemDiffCallback : DiffUtil.ItemCallback<CharacterAdapterItem>() {
    override fun areItemsTheSame(oldItem: CharacterAdapterItem, newItem: CharacterAdapterItem) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: CharacterAdapterItem, newItem: CharacterAdapterItem) =
        oldItem == newItem
}