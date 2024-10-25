package com.example.visitcountry.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.visitcountry.CountryApps
import com.example.visitcountry.DetailsScreenApp
import com.example.visitcountry.OutScreenApp
import com.example.visitcountry.RezervationApp

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.homepageScreen.route){
        composable(route = Screens.homepageScreen.route){
            CountryApps(navController = navController)
        }
        composable(route = Screens.datailsScreen.route){
            DetailsScreenApp(navController = navController)
        }
        composable(route =Screens.rezervationScreen.route){
            RezervationApp(navController = navController)
        }
        composable(route = Screens.outScreen.route){
            OutScreenApp(navController = navController)
        }
    }
}