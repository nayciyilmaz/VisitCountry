package com.example.visitcountry.navigation

sealed class Screens(val route: String) {
    data object homepageScreen : Screens("homepage_screen")
    data object datailsScreen : Screens("details_screen")
    data object rezervationScreen : Screens("rezervation_secreen")
    data object outScreen : Screens("out_screen")
}