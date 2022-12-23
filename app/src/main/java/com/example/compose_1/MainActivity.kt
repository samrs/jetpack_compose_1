package com.example.compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_1.ui.LocalSpacing
import com.example.compose_1.ui.spacing
import com.example.compose_1.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewCompose()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCompose() {
        ComposeTheme {
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier.padding(
                    MaterialTheme.spacing.small
                )
            ) {
                LocalSpacing.current.medium
            }
        }
    }

}
