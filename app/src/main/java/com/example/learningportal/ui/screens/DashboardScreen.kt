package com.example.learningportal.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.learningportal.R
import com.example.learningportal.ui.theme.LearningPortalTheme

@Composable
fun DashboardScreen(navHostController: NavHostController = rememberNavController()) {

    Column {
        UserProfilePic()
        Text(
            text = stringResource(id = R.string.what_would_you_like),
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
private fun UserProfilePic() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier) {
        Image(
            ImageBitmap.imageResource(R.drawable.user_1),
            contentDescription = "Logo",
            modifier = Modifier.size(80.dp)
        )

        Text(
            text = stringResource(id = R.string.user_greeting),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DashboardScreenPreview() {
    LearningPortalTheme {
        DashboardScreen()
    }
}