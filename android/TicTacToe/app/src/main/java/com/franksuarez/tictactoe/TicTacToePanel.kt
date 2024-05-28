package com.franksuarez.tictactoe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


/**
 * TODO: create button grid
 * TODO: pass callback list for buttons
 * TODO: pass
 */

@Composable
fun TicTacToePanel(modifier: Modifier = Modifier,btnTextList: List<String> = listOf()) {

    Column {
        Row {
            Button(onClick = {}) {

            }
            Button(onClick = {}) {




            }
            Button(onClick = {}) {}
        }
        Row {
            Button(onClick = {}) {}
            Button(onClick = {}) {}
            Button(onClick = {}) {}
        }
        Row {
            Button(onClick = {}) {}
            Button(onClick = {}) {}
            Button(onClick = {}) {}
        }
    }
}

@Preview
@Composable
fun TicTacToePanelPreview() {
    var btnText = listOf("button1","button2")


    TicTacToePanel()
}