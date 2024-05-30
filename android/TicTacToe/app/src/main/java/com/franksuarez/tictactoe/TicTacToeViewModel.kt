package com.franksuarez.tictactoe

import android.util.Log
import androidx.lifecycle.ViewModel
import com.franksuarez.tictactoe.model.TicTacToeBoard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TicTacToeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TicTacToeBoard().initialize())
    val uiState: StateFlow<TicTacToeBoard> = _uiState.asStateFlow()


    fun getPlayerTokenImageRes(player: TicTacToeBoard.Player): Int? {

        var output = when (player) {
            TicTacToeBoard.Player.NOPLAYER -> null
            TicTacToeBoard.Player.PLAYER1 -> R.drawable.xleft
            TicTacToeBoard.Player.PLAYER2 -> R.drawable.oleft
        }
        return output
    }


    fun isCellOccupied(x: Int, y: Int): Boolean {
        var token = uiState.value.getToken(x,y)
        var output: Boolean
        when (token) {
            TicTacToeBoard.Player.NOPLAYER -> output = false
            TicTacToeBoard.Player.PLAYER1 -> output = true
            TicTacToeBoard.Player.PLAYER2 -> output = true
        }
        return output
    }
}