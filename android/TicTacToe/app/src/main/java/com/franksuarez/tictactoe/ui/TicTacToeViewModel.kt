package com.franksuarez.tictactoe.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.franksuarez.tictactoe.R
import com.franksuarez.tictactoe.model.TicTacToeBoard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TicTacToeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TicTacToeBoard().initialize())
    val uiState: StateFlow<TicTacToeBoard> = _uiState.asStateFlow()

    private val player1ImageRes: Int? = R.drawable.xleft
    private val player2ImageRes: Int? = R.drawable.oleft

    fun getPlayerAtLocation(x: Int, y: Int):TicTacToeBoard.Player {
        return uiState.value.getToken(x,y)
    }

    fun getImageResAtLocation(x: Int, y: Int): Int? {
        val player = getPlayerAtLocation(x, y)
        val imageRes = getPlayerTokenImageRes(player)
        return imageRes
    }

    fun makeMove(x: Int, y: Int) {
        uiState.value.makeMove(x,y)
    }

    fun switchPlayer() {
        uiState.value.switchPlayer()
    }

    fun getPlayerTokenImageRes(player: TicTacToeBoard.Player): Int? {
        Log.d(TicTacToeApp.TAG,"getPlayerTokenImageRes()")
        var output = when (player) {
            TicTacToeBoard.Player.NOPLAYER -> null
            TicTacToeBoard.Player.PLAYER1 -> R.drawable.xleft
            TicTacToeBoard.Player.PLAYER2 -> R.drawable.oleft
        }
        return output
    }

    fun isCellOccupied(x: Int, y: Int): Boolean {
        Log.d(TicTacToeApp.TAG,"isCellOccupied()")
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