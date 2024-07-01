package com.example.marvelharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.marvelharacters.ui.theme.MarvelСharactersTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarvelСharactersTheme {
                Scaffold{ padding ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                            /*.background(Color.Gray)*/){
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            /*.background(Color.Red)*/,
                            horizontalArrangement = Arrangement.Center)
                        {
                            Logo()
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            /*.background(Color.Yellow)*/,
                            horizontalArrangement = Arrangement.Center)
                        {
                            Title()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun Logo(){
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = null ,
        modifier = Modifier
            .width(160.dp)
            .padding(vertical = 32.dp)
    )
}

@Composable
private fun Title(){
    Text(text = "Choose your hero",
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White)
}

