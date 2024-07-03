package com.example.marvelharacters


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Deadpool(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.deadpool), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier
            .fillMaxSize()
        )
        Column (modifier = Modifier
            .align(Alignment.BottomStart)){
            Text(text = "Deadpool", color = Color.White, fontSize = 32.sp, modifier = Modifier
                .padding(start = 30.dp, top = 20.dp))
            Text(text = "Please don't make the super suit green...or animated!", color = Color.White, fontSize = 24.sp, modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 40.dp))
            }
        Image(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .padding(vertical = 32.dp, horizontal = 16.dp)
                .clickable{
                    navController.navigate(route = "home")
                }
        )
    }
}