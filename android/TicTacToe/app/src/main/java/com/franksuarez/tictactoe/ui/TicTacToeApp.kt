package com.franksuarez.tictactoe.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.franksuarez.tictactoe.R
import com.franksuarez.tictactoe.ui.theme.TicTacToeTheme



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
fun MainApp( modifier: Modifier = Modifier) {
    NewPanel(modifier = modifier)

}

@Composable
fun NewPanel(modifier: Modifier = Modifier) {

    var gameViewModel: TicTacToeViewModel = viewModel()
    val tttUiState by gameViewModel.uiState.collectAsState()

    val imageResList = remember {
        mutableStateListOf<Int?>(
            R.drawable.xleft,null,null,
            null,null,null,
            null,null,null,
            )
    }







    Column {
        var count: Int = 0
        for (y in 0..2) {
            Row {

                for (x in 0..2) {

                    Column {
                        Text(String.format("c%d",count))
                        BoardCell(
                            imageRes = null,
                            enabled = true,
                            onClick = {
                                val currentCount = count
                                Log.d(TicTacToeApp.TAG,String.format("BoardCell(%d,%d) (count = %d) (newcount = %d) clicked",x,y,currentCount,y*3+x))
                                //gameViewModel.makeMove(x, y)
                                //imageResList.set(count, gameViewModel.getImageResAtLocation(0, 0))


                                //imageResList.set(count, R.drawable.oleft)
                                //gameViewModel.switchPlayer()
                            },
                            modifier = modifier.size(100.dp)
                        )
                    }

                    count++
                }
            }
        }
    }

}



@Preview
@Composable
fun MainAppPreview() {
    TicTacToeTheme {
        MainApp()
    }
}