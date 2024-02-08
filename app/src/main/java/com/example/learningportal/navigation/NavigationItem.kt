package com.example.learningportal.navigation

enum class Screen {
    Dashboard, PopularCourse, Home
}

sealed class NavigationItem(val route: String) {

    object Home : NavigationItem(Screen.Home.name)
    object Dashboard : NavigationItem(Screen.Dashboard.name)
    object PopularCourse : NavigationItem(Screen.PopularCourse.name)
}