package com.example.compose_1.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class ConstraintLay {

    @Preview(showBackground = true, device = Devices.PIXEL_2_XL)
    @Composable
    fun ConstraintLayout() {
        val greenBoxId = "greenbox"
        val redBoxId = "redbox"

        val constraints = ConstraintSet {
            val greenBox = createRefFor(greenBoxId)
            val redBox = createRefFor(redBoxId)
            val guideLine = createGuidelineFromTop(0.5f)

            constrain(greenBox) {
                top.linkTo(guideLine)
                start.linkTo(parent.start)
                width = Dimension.value(200.dp)
                height = Dimension.value(200.dp)
            }
            constrain(redBox) {
                top.linkTo(parent.top)
                start.linkTo(greenBox.end)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.value(200.dp)
            }
            createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
        }
        ConstraintLayout(
            constraintSet = constraints,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier
                .background(Color.Green)
                .layoutId(greenBoxId)
            )
            Box(modifier = Modifier
                .background(Color.Red)
                .layoutId(redBoxId)
            )
        }
    }
}
