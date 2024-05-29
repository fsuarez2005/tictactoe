package com.franksuarez.tictactoe

import android.util.Log
import androidx.lifecycle.ViewModel
import com.franksuarez.tictactoe.model.TicTacToeBoard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TicTacToeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TicTacToeState({
        var t: TicTacToeBoard = TicTacToeBoard()
        t.initialize()
        t
    }()))
    val uiState: StateFlow<TicTacToeState> = _uiState.asStateFlow()

    //private lateinit var currentPlayer: TicTacToeBoard.Player
    fun getPlayerTokenImageRes(player: TicTacToeBoard.Player): Int? {

        var output = when (player) {
            TicTacToeBoard.Player.NOPLAYER -> null
            TicTacToeBoard.Player.PLAYER1 -> R.drawable.xleft
            TicTacToeBoard.Player.PLAYER2 -> R.drawable.oleft
        }
        return output
    }




}