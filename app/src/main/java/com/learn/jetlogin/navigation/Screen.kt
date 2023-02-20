package com.learn.jetlogin.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home/{username}") {
        fun createRoute(username: String): String {
            return "home/$username"
        }
    }
}