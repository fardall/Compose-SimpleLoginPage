package com.learn.jetlogin

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.learn.jetlogin.navigation.Screen

@Composable
fun JetLoginApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Login.route) {
                LoginScreen(
                    navigateToHome = { username ->
                        navController.navigate(Screen.Home.createRoute(username)) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(
                route = Screen.Home.route,
                arguments = listOf(navArgument("username") { type = NavType.StringType })
            ) {
                val username = it.arguments?.getString("username") ?: ""
                HomeScreen(
                    username = username
                )
            }
        }
    }
}