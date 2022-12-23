package com.example.compose_1.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class StateBox {

    @Composable
    fun SetState() {
        val color = remember {
            mutableStateOf(Color.Yellow)
        }
        Column(Modifier.fillMaxSize()) {
            BoxWithState(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                color = color
            )
            Box(
                modifier = Modifier
                    .background(color = color.value)
                    .fillMaxSize()
                    .weight(1f)
            ) {

            }
        }
    }

    @Composable
    fun BoxWithState(
        modifier: Modifier = Modifier,
        color: MutableState<Color>
    ) {
        Box(modifier = modifier
            .background(Color.Red)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            }
        )
    }
}
