package com.example.compose_1.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FirstCompose {

    @Preview(showBackground = true, device = Devices.PIXEL_2_XL)
    @Composable
    fun TestCompose() {
        Column {
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Cyan)
                    .padding(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Hola mundo",
                        fontSize = 30.sp
                    )
                    Text(
                        text = "Android",
                        fontSize = 30.sp
                    )
                }
                Text(
                    text = "Samuel",
                    fontSize = 30.sp
                )
            }
        }
    }
}
