package com.example.rickandmorty.view.adapter.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R

class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val image: ImageView = view.findViewById(R.id.character_image)
    val name: TextView = view.findViewById(R.id.name)
    val gender: TextView = view.findViewById(R.id.gender)
}