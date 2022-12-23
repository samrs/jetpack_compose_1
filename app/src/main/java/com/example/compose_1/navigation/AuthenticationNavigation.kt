package com.example.compose_1

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose_1.navigation.AUTHENTICATION_ROUTE
import com.example.compose_1.navigation.Screen

fun NavGraphBuilder.authenticationNavigation(navController: NavController) {
    navigation(
        startDestination = Screen.LoginScreen.route,
        route = AUTHENTICATION_ROUTE
    ) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
    }
}
