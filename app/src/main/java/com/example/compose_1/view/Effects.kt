package com.example.compose_1.view

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay

class Effects {
    private var i = 0

    @Composable
    fun Effect() {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(scaffoldState = scaffoldState) {
            val counter = produceState(initialValue = 2) {
                delay(3000L)
                value++
            }
            if (counter.value % 5 == 0 && counter.value > 0) {
                // cancel coroutine when it is not multiple of 5
                LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                    scaffoldState.snackbarHostState.showSnackbar("Hello")
                }
            }
            Button(onClick = {  }) {
                Text(text = "Click me: ${counter.value}")
            }
        }
    }

    @Composable
    fun SideHandlerEffects(backPressedDispatcher: OnBackPressedDispatcher) {
        val callback =  remember {
            object: OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    TODO("Not yet implemented")
                }
            }
        }
        SideEffect {
            i++
        }
        DisposableEffect(key1 = backPressedDispatcher) {
            backPressedDispatcher.addCallback(callback)
            onDispose {
                callback.remove()
            }
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Click this")
        }
    }
}
