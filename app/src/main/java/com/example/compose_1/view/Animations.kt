package com.example.compose_1.view

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class Animations {
    @Composable
    fun Animations() {
        var sizeState by remember { mutableStateOf(200.dp) }
        val animationSpecTween: AnimationSpec<Dp> = tween(
            durationMillis = 3000,
            delayMillis = 300,
            easing = LinearOutSlowInEasing
        )
        val animationSpecSpring: AnimationSpec<Dp> = spring(
            Spring.DampingRatioHighBouncy
        )
        val animationKeyFrames: AnimationSpec<Dp> = keyframes {
            durationMillis =  5000
            sizeState at 0 with LinearEasing
            sizeState * 1.5f at 1000 with FastOutLinearInEasing
            sizeState * 2f at 5000
        }
        val infiniteTransition = rememberInfiniteTransition()
        val color by infiniteTransition.animateColor(
            initialValue = Color.Red,
            targetValue = Color.Green,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 3000),
                repeatMode = RepeatMode.Reverse
            )
        )

        val size by animateDpAsState(
            targetValue = sizeState,
            animationSpec = animationKeyFrames
        )

        Box(
            modifier = Modifier
                .size(size)
                .background(color),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                sizeState += 50.dp
            }) {
                Text(text = "Increase Size")
            }
        }
    }
}
