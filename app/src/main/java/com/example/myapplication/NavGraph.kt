package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


sealed class Screens( val routeName: String){
    object ListScreen:Screens("list")
    object ProductDetailScreen:Screens("detail")
}

@Composable
fun NavGraph(navHostController: NavHostController){
    NavHost(
        startDestination = Screens.ListScreen.routeName,
        navController = navHostController
    ) {
        composable(Screens.ListScreen.routeName){
            ListScreen(navController = navHostController)
        }
        composable("${Screens.ProductDetailScreen.routeName}/{productId}"){
                backStackEntry ->
            val productIdString = backStackEntry.arguments?.getString("productId")
            val productId = productIdString?.toIntOrNull() // Chuyển đổi sang Int an toàn

            if (productId != null) {
                ProductDetailScreen(productId = productId, navController = navHostController)
            }

        }
//        composable(Screens.ProductDetailScreen.routeName){
//
//            ProductDetailScreen(navController = navHostController)
//
//        }
    }
}