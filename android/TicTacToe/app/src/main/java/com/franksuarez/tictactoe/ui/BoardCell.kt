package com.franksuarez.tictactoe.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.franksuarez.tictactoe.R
import com.franksuarez.tictactoe.ui.theme.TicTacToeTheme


@Composable
fun BoardCell(
    modifier: Modifier = Modifier,
    imageRes: Int? = R.drawable.xleft,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = {},

) {
    Box(
        modifier = modifier
            .clickable(
                enabled = enabled,
                onClick = {
                    Log.d(TicTacToeApp.TAG,"box click")
                    onClick?.invoke()
                })
            .border(width = 1.dp,color = Color.Black)
    ) {
        if (imageRes != null) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "",
                modifier = modifier
            )
        } else {
            Box(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .size(100.dp)
            ) {

            }
        }
    }
}


@Preview
@Composable
fun BoardCellPreview() {
    TicTacToeTheme {
        var cellEnabled by remember {
            mutableStateOf(true)
        }
        var cellImage by remember {
            mutableStateOf<Int?>(null)
        }

        BoardCell(
            imageRes = cellImage,
            enabled = true,
            onClick = {
                cellImage = R.drawable.oleft
                cellEnabled = false
            },
            modifier = Modifier.size(size = 100.dp)

        )
    }
}


