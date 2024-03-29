package com.example.learningportal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learningportal.ui.screens.DashboardScreen
import com.example.learningportal.ui.screens.SplashScreen
import com.example.learningportal.ui.screens.PopularCoursesScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {

    NavHost(
        startDestination = NavigationItem.Dashboard.route,
        navController = navHostController,
        modifier = modifier
    ) {
        composable(NavigationItem.Home.route) {
            SplashScreen(
                navHostController = navHostController,
                startApp = {}
            )
        }

        composable(NavigationItem.Dashboard.route) {
            DashboardScreen(navHostController = navHostController)
        }

        composable(NavigationItem.PopularCourse.route) {
            PopularCoursesScreen(navHostController = navHostController)
        }
    }
}