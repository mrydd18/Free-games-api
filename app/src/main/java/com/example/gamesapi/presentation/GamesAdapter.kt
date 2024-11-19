package com.example.gamesapi.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamesapi.data.Game
import com.example.gamesapi.databinding.ItemGamesBinding

class GamesAdapter : RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    private var currentGames: List<Game> = emptyList()

    fun setGameList(games: List<Game>) {
        currentGames = games
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val binding = ItemGamesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val game = currentGames[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int = currentGames.size

    class GamesViewHolder(private val binding: ItemGamesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game) = with(binding) {
            titleTextView.text = game.title
            genreTextView.text = game.genre
            Glide.with(gamesImages)
                .load(game.thumbnail)
                .into(gamesImages)
        }
    }
}