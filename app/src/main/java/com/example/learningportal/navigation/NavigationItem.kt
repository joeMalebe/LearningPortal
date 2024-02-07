package com.example.learningportal.navigation

enum class Screen {
    Dashboard, Course, Home
}

sealed class NavigationItem(val route: String) {

    object Home : NavigationItem(Screen.Home.name)
    object Dashboard : NavigationItem(Screen.Dashboard.name)
    object Course : NavigationItem(Screen.Course.name)
}