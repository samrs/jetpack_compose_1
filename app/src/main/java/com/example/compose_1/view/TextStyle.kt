package com.example.compose_1.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.compose_1.R

class TextStyle() {

    @Composable
    fun Text() {
        val fontFamily = FontFamily(
            Font(R.font.roboto_serif_regular, FontWeight.Thin),
            Font(R.font.roboto_serif_medium, FontWeight.Normal),
            Font(R.font.roboto_serif_semi_bold, FontWeight.Bold)
        )

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
        ) {
            androidx.compose.material.Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green,
                            fontSize = 50.sp
                        )
                    ) {
                        append("Jet")
                    }
                    append("pack")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green,
                            fontSize = 50.sp
                        )
                    ) {
                        append("Com")
                    }
                    append("pose")
                },
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}
