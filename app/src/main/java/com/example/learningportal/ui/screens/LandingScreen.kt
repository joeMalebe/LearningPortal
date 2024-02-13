package com.example.learningportal.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.learningportal.R
import com.example.learningportal.navigation.NavigationItem
import com.example.learningportal.ui.theme.LearningPortalTheme
import kotlinx.coroutines.time.delay
import java.time.Duration

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    alphaAnimation: Animatable<Float, AnimationVector1D> = remember {
        Animatable(0f)
    },
    navHostController: NavHostController = rememberNavController(),
    startApp:() -> Unit
) {

    LaunchedEffect(alphaAnimation) {

        alphaAnimation.animateTo(
        targetValue = 1f,
        animationSpec = androidx.compose.animation.core.tween(
            durationMillis = 1000, easing = FastOutLinearInEasing
        ))
        delay(Duration.ofMillis(500))
        startApp()
    }

    Box(modifier = modifier
        .fillMaxSize()
        .alpha(alphaAnimation.value), contentAlignment = Alignment.Center) {
        Image(
            ImageBitmap.imageResource(R.drawable.top_tight),
            contentDescription = "Top Right",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(width = 108.dp, height = 90.dp)
                .align(Alignment.TopEnd)
        )
        Image(
            ImageBitmap.imageResource(R.drawable.bottom_left),
            contentDescription = "Bottom start",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(width = 108.dp, height = 90.dp)
                .align(Alignment.BottomStart)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.logo),
                contentDescription = "Logo",
                Modifier.padding(bottom = 24.dp)
            )
            Text(
                text = stringResource(id = R.string.elevate),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.today),
                contentDescription = "Today",
                modifier = Modifier
                    .size(width = 200.dp, height = 80.dp)
                    .clickable {
                        navHostController.navigate(NavigationItem.Dashboard.route)
                    }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LandingScreenPreview() {
    LearningPortalTheme {
        SplashScreen(startApp = {})
    }
}