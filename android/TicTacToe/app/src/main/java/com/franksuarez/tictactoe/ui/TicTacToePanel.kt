package com.franksuarez.tictactoe.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.franksuarez.tictactoe.model.TicTacToeBoard
import com.franksuarez.tictactoe.ui.theme.TicTacToeTheme


/**
 * TODO: create button grid
 * TODO: pass callback list for buttons
 * TODO: pass
 */

@Composable
fun TicTacToePanel(
    modifier: Modifier = Modifier,
    gameViewModel: TicTacToeViewModel = viewModel(),
) {
    val tttUiState by gameViewModel.uiState.collectAsState()

    var player by remember {
        mutableStateOf(TicTacToeBoard.Player.PLAYER1)
    }

    Column {


    }
}


@Preview
@Composable
fun TicTacToePanelPreview() {
    TicTacToeTheme {

    }
}