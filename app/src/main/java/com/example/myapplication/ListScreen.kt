package com.example.myapplication

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController){

    var context = LocalContext.current
    val viewModel = ListScreenViewModel(context)

    val activity = (LocalContext.current as? Activity)
    var products by remember {
        mutableStateOf(viewModel.getProducts())}

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                actions = {
                    IconButton(onClick = {
                    activity?.finishAndRemoveTask()
                }, content = {Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = null)}) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                title = {
                    Text("Thuc don")
                }
            )
        }
    ) {
        LazyColumn(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            items(products){

                ProductCard(it, onClick = {
                    var productId = it.id
                    navController.navigate("${Screens.ProductDetailScreen.routeName}/$productId")
                })
            }
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun ProductCardp(){
//    MaterialTheme{
//        ListScreen()
//    }
//}
