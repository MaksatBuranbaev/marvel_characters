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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
                        .padding(padding)){
                        Logo()
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