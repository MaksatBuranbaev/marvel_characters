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
import com.example.marvelharacters.ui.theme.MarvelСharactersTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MarvelСharactersTheme {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Home(navController)
                    }
                    composable("deadpool") {
                        Deadpool(navController)
                    }
                    composable("iron man") {
                        Iron_man(navController)
                    }
                    composable("spider-man") {
                        Spider_man(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavController) {
    Scaffold { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .paint(
                    painterResource(id = R.drawable.background),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                /*.background(Color.Red)*/,
                horizontalArrangement = Arrangement.Center
            )
            {
                Logo()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                /*.background(Color.Yellow)*/,
                horizontalArrangement = Arrangement.Center
            )
            {
                Title()
            }
            val characters = listOf(
                Character("Deadpool", R.drawable.deadpool),
                Character("Iron Man", R.drawable.iron_man),
                Character("Spider-Man", R.drawable.sp)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(characters) { character ->
                    CharacterImage(
                        name = character.name,
                        img = character.image,
                        navagationController = navController
                    )
                }
            }
        }
    }
}

@Composable
private fun Logo() {
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = null,
        modifier = Modifier
            .width(160.dp)
            .padding(vertical = 32.dp)
    )
}

@Composable
private fun Title() {
    Text(
        text = "Choose your hero",
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier.padding(bottom = 32.dp)
    )
}

@Composable
private fun CharacterImage(name: String, img: Int, navagationController: NavController) {
    Box(
        contentAlignment = Alignment.BottomStart, modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 60.dp)
    ) {
        Image(painter = painterResource(id = img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(360.dp, 800.dp)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    navagationController.navigate(route = name.lowercase())
                }
        )
        Text(
            text = name, color = Color.White, fontSize = 32.sp, modifier = Modifier
                .padding(start = 30.dp, bottom = 40.dp)
        )
    }
}

data class Character
    (
    val name: String,
    val image: Int,
)
