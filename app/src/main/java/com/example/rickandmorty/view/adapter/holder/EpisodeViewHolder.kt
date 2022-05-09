package com.example.rickandmorty.view.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R

class EpisodeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.episode_name)
    val date: TextView = view.findViewById(R.id.episode_date)
}