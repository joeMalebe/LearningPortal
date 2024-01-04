package com.example.learningportal.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.learningportal.CourseCategory
import com.example.learningportal.R
import com.example.learningportal.ui.theme.LearningPortalTheme

@Composable
fun DashboardScreen(
    navHostController: NavHostController = rememberNavController(),
    categoryList: List<CourseCategory> = CourseCategory.getCourseCategories()
) {

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        UserProfilePic(modifier = Modifier.wrapContentHeight())
        Text(
            text = stringResource(id = R.string.what_would_you_like),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
        val category = CourseCategory.getCourseCategories().first()

        LazyVerticalGrid(
            columns = GridCells.Adaptive(128.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(categoryList.size) {
                CategoryItem(categoryList[it])
            }
        }
    }
}

@Composable
private fun CategoryItem(category: CourseCategory, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(vertical = 16.dp)
            .aspectRatio(1f)
            .background(
                color = colorResource(id = category.backgroundColor),
                shape = RoundedCornerShape(32.dp)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(category.image),
                contentDescription = category.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .wrapContentSize()
            )
            Text(
                text = category.name,
                modifier = Modifier.padding(top = 16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

    }
}

@Composable
private fun UserProfilePic(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Image(
            ImageBitmap.imageResource(R.drawable.user_1),
            contentDescription = "Logo",
            modifier = Modifier.wrapContentSize(),
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

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CategoryItemPreview() {
    LearningPortalTheme {
        CategoryItem(CourseCategory.getCourseCategories()[2])
    }
}