package com.example.lemonade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        LemonadeApp()
        }
    }
}

@Preview
@Composable
fun LemonadeApp (){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Card()
    }
}


@Composable
fun Card (
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ) {
        var result by remember { mutableStateOf(1) }
        var random by remember { mutableStateOf(0) }
        var description: String
        var paint: Painter
        var content: String

        when (result) {
            1 -> {
                description = stringResource(id = R.string.lemon_content)
                paint = painterResource(id = R.drawable.lemon_tree)
                content = stringResource(id = R.string.lemon_tree)
            }
            2 -> {
                description = stringResource(id = R.string.squeeze_it)
                paint = painterResource(id = R.drawable.lemon_squeeze)
                content = stringResource(id = R.string.lemon)
            }
            3 -> {
                description = stringResource(id = R.string.drink_it)
                paint = painterResource(id = R.drawable.lemon_drink)
                content = stringResource(id = R.string.glass)

            }
            else -> {
                description = stringResource(id = R.string.empty_glass)
                paint = painterResource(id = R.drawable.lemon_restart)
                content = stringResource(id = R.string.empty)
            }
        }


        Text(
            text = description,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
                painter = paint,
                contentDescription = content,

                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp)
                    .border(
                        2.dp, color = Color(105, 205, 216),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clickable {
                        when (result) {
                            1 -> {
                                result = 2
                                random = (2..4).random()
                            }
                            2 -> {
                                random--
                                if (random == 0) result = 3
                            }
                            3 -> result = 4

                            4 -> result = 1
                        }
                        Log.d("button", result.toString())
                    }

            )

    }
}
