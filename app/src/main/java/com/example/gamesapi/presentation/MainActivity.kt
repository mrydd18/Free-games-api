package com.example.gamesapi.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamesapi.data.GamesRepository
import com.example.gamesapi.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val gamesAdapter = GamesAdapter()
    private val gamesRepository = GamesRepository()
    private val viewModel by viewModels<GamesViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getGames()
        GamesViewModel()
        initRecycler()
        setCollectors()

    }

    private fun initRecycler() {
        binding.gamesRecyclerView.apply {
            adapter = gamesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
    private fun setCollectors() = lifecycleScope.launch {
        viewModel.gamesFlow.collect {game ->
            gamesAdapter.setGameList(game)
        }
    }

}

