package com.franksuarez.tictactoe

import android.util.Log
import androidx.collection.mutableFloatLongMapOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.franksuarez.tictactoe.model.TicTacToeBoard
import com.franksuarez.tictactoe.ui.theme.TicTacToeTheme


/**
 * TODO: create button grid
 * TODO: pass callback list for buttons
 * TODO: pass
 */

@Composable
fun TicTacToePanel(gameViewModel: TicTacToeViewModel = viewModel(), modifier: Modifier = Modifier) {
    val tttUiState by gameViewModel.uiState.collectAsState()

    var player by remember {
        mutableStateOf(TicTacToeBoard.Player.PLAYER1)
    }

    Column {
        BoardCell(
            imageRes = gameViewModel.getPlayerTokenImageRes(player),
            onClick = {
                Log.d(TicTacToeApp.TAG,"clicked")
                tttUiState.board.switchPlayer()
                player = tttUiState.board.currentPlayer
            }
            )
    }
}


@Composable
fun BoardCell(
    imageRes: Int? = R.drawable.xleft,
    onClick: (() -> Unit)? = {},
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
) {

    var onClickCallback: (() -> Unit)? = {}
    if (enabled) {
        onClickCallback = onClick
    } else {
        onClickCallback = null
    }




    Box(modifier) {
        if (imageRes != null) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "",
                modifier.clickable { onClickCallback?.invoke() })
        } else {

            Image(painter = painterResource(id = R.drawable.blank), contentDescription = "",modifier=modifier)
        }
    }
}


@Preview
@Composable
fun BoardCellPreview() {
    TicTacToeTheme {
        BoardCell(imageRes = null, modifier = Modifier
            .height(100.dp)
            .width(100.dp))
    }
}

@Preview
@Composable
fun TicTacToePanelPreview() {
}