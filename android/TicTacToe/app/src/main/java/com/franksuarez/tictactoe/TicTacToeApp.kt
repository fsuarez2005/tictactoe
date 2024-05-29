package com.franksuarez.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.franksuarez.tictactoe.ui.theme.TicTacToeTheme

//import androidx.lifecycle.viewmodel.compose.viewModel


class TicTacToeApp : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }


    companion object {
        val TAG: String = "tictactoe"

    }
}


@Composable
fun MainApp(gameViewModel: TicTacToeViewModel = viewModel(), modifier: Modifier = Modifier) {
    val tttUiState by gameViewModel.uiState.collectAsState()

    TicTacToePanel(gameViewModel, modifier)

}


@Preview
@Composable
fun MainAppPreview() {
    TicTacToeTheme {
        MainApp()
    }
}