package com.example.gamesapi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapi.data.Game
import com.example.gamesapi.data.GamesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GamesViewModel : ViewModel() {

    private val gamesRepository = GamesRepository()

    val gamesFlow = MutableStateFlow<List<Game>>(emptyList())

    fun getGames() = viewModelScope.launch {
       val games = gamesRepository.getApi() ?: emptyList()
        gamesFlow.emit(games)

    }
}