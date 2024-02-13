package com.example.learningportal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.learningportal.ui.screens.SplashScreen
import com.example.learningportal.ui.theme.LearningPortalTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LearningPortalTheme {
                // A surface container using the 'background' color from the theme
                SplashScreen(startApp = { startActivity(Intent(this@SplashActivity ,MainActivity::class.java)) })
            }
        }
    }
}