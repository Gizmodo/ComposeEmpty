package com.one.composeempty

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.one.composeempty.ui.theme.ComposeEmptyTheme
import com.one.composeempty.ui.theme.TicketShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeEmptyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    //  Greeting("Android")
                    // DrawLine()
                    // drawRect(modifier = Modifier.fillMaxWidth())
                    MainContent()
                }
            }
        }
    }
}

fun drawTicketPath(size: Size, cornerRadius: Float): Path {
    return Path().apply {
        reset()
        // Top left arc
        arcTo(
            rect = Rect(
                left = -cornerRadius,
                top = -cornerRadius,
                right = cornerRadius,
                bottom = cornerRadius
            ),
            startAngleDegrees = 90.0f,
            sweepAngleDegrees = -90.0f,
            forceMoveTo = false
        )
        lineTo(x = size.width - cornerRadius, y = 0f)
        // Top right arc
        arcTo(
            rect = Rect(
                left = size.width - cornerRadius,
                top = -cornerRadius,
                right = size.width + cornerRadius,
                bottom = cornerRadius
            ),
            startAngleDegrees = 180.0f,
            sweepAngleDegrees = -90.0f,
            forceMoveTo = false
        )
        lineTo(x = size.width, y = size.height - cornerRadius)
        // Bottom right arc
        arcTo(
            rect = Rect(
                left = size.width - cornerRadius,
                top = size.height - cornerRadius,
                right = size.width + cornerRadius,
                bottom = size.height + cornerRadius
            ),
            startAngleDegrees = 270.0f,
            sweepAngleDegrees = -90.0f,
            forceMoveTo = false
        )
        lineTo(x = cornerRadius, y = size.height)
        // Bottom left arc
        arcTo(
            rect = Rect(
                left = -cornerRadius,
                top = size.height - cornerRadius,
                right = cornerRadius,
                bottom = size.height + cornerRadius
            ),
            startAngleDegrees = 0.0f,
            sweepAngleDegrees = -90.0f,
            forceMoveTo = false
        )
        lineTo(x = 0f, y = cornerRadius)
        close()
    }
}

@Composable
fun TicketComposable(modifier: Modifier) {
    Text(
        text = "🎉 CINEMA TICKET 🎉",
        style = TextStyle(
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
        ),
        textAlign = TextAlign.Center,
        modifier = modifier
            .wrapContentSize()
            .graphicsLayer {
                shadowElevation = 8.dp.toPx()
                shape = TicketShape(24.dp.toPx())
                clip = true
            }
            .background(color = Color(0xFF111720))
            .drawBehind {
                scale(scale = 0.9f) {
                    drawPath(
                        path = drawTicketPath(size = size, cornerRadius = 24.dp.toPx()),
                        color = Color(0xFFFA0000),
                        style = Stroke(
                            width = 2.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                        )
                    )
                }
            }
            .padding(start = 32.dp, top = 64.dp, end = 32.dp, bottom = 64.dp)
    )
}

@Composable
fun MainContent() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFDAE9))
            .padding(5.dp)
    )
    {
        val height = size.height
        val width = size.width
        drawRect(
            color = Color(0xFF26619C),
            size = Size(
                width = width ,
                height = 213.dp.toPx()
            ),
            style = Stroke(
                width = 1.dp.toPx(),
                miter = 10.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            )
        )
        Modifier
            .padding(10.dp)
            .size(150.dp)
            .composed {
                drawRect(

                    color = Color(0xFF000000),
                    size = Size(
                        width = width,
                        height = 203.dp.toPx()
                    ),
                    style = Stroke(
                        width = 1.dp.toPx(),
                        miter = 10.dp.toPx(),
                    )
                )
            }

        drawLine(Color.Red,
            strokeWidth = 1.dp.toPx(),
            start = Offset(0f, 0.dp.toPx()),
            end = Offset(width, 0.dp.toPx())
        )
        drawLine(Color.Black,
            strokeWidth = 2.dp.toPx(),
            start = Offset(0f, 129.dp.toPx()),
            end = Offset(width, 129.dp.toPx())
        )
    }
}

@Composable
fun DrawLine() {
    Column(modifier = Modifier.size(350.dp, 215.dp)) {
        Row {
            Text(
                text = "Скидки не распростроняются",
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Canvas(modifier = Modifier.size(350.dp, 215.dp)) {
            val height = size.height
            val width = size.width

            drawRect(
                color = Color(0xFFEFB8C8),
                topLeft = Offset(0f, 0f),
                size = Size(width, height),
            )
            drawLine(Color.Black,
                strokeWidth = 1.dp.toPx(),
                start = Offset(0f, 22.dp.toPx()),
                end = Offset(350.dp.toPx(), 22.dp.toPx())
            )
            drawLine(Color.Black,
                strokeWidth = 2.dp.toPx(),
                start = Offset(0f, 129.dp.toPx()),
                end = Offset(350.dp.toPx(), 129.dp.toPx())
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Виски Синглтон. шотл",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Вискокурня Даффтаун",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(47.dp)
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "12лет шотл односолод",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(67.dp)
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "40% 0.5л Соединенное",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(87.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeEmptyTheme {
        //DrawLine()
//TicketComposable(modifier = Modifier.fillMaxWidth())
        MainContent()
    }
}