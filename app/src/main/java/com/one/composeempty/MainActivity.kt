package com.one.composeempty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.one.composeempty.ui.theme.ComposeEmptyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* setContent {
             ComposeEmptyTheme {
                 // A surface container using the 'background' color from the theme
                 Surface(modifier = Modifier.fillMaxSize(),
                     color = MaterialTheme.colorScheme.background) {
                     Greeting("Android")
                 }
             }
         }*/
    }
}

@Composable
fun DrawLine() {

    Column(modifier = Modifier.size(350.dp,215.dp)) {

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
    ){
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
    ){
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
    ){
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
    ){
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

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeEmptyTheme {
        DrawLine()
        Greeting("Android")
    }
}