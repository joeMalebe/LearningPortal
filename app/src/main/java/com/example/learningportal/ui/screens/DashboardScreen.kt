package com.example.learningportal.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.learningportal.R
import com.example.learningportal.data.Course
import com.example.learningportal.data.CourseCategory
import com.example.learningportal.ui.MyBottomAppBar
import com.example.learningportal.ui.theme.Cream
import com.example.learningportal.ui.theme.LearningPortalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navHostController: NavHostController = rememberNavController(),
    categoryList: List<CourseCategory> = CourseCategory.getCourseCategories()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        bottomBar = {
            MyBottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .padding(8.dp),

                containerColor = Color.White,
                contentColor = Color.Gray,
                contentPadding = PaddingValues(0.dp),
                shadowElevation = 36.dp,

                content = {

                    IconButton(onClick = { }) {
                        Icon(
                            ImageBitmap.imageResource(R.drawable.bottom_btn1),
                            contentDescription = "Home",
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                    IconButton(onClick = {  }) {
                        Icon(
                            ImageBitmap.imageResource(R.drawable.bottom_btn2),
                            contentDescription = "Wallet",
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                    IconButton(onClick = {  }) {
                        Icon(
                            ImageBitmap.imageResource(R.drawable.bottom_btn3),
                            contentDescription = "Profile",
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                    IconButton(onClick = {  }) {
                        Icon(
                            ImageBitmap.imageResource(R.drawable.bottom_btn4),
                            contentDescription = "Settings",
                            modifier = Modifier.wrapContentSize()
                        )
                    }

                },

                )
        }, modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()

        ) {
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
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 200.dp, max = 410.dp)
            ) {
                items(categoryList.size) {
                    CategoryItem(categoryList[it])
                }
            }
            PopularCourses()
        }
    }
}

@Composable
private fun CategoryItem(category: CourseCategory, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(vertical = 8.dp)
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
fun PopularCourses(course: Course = Course.getCourses()[0]) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.popular_courses),
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Course(course)
    }
}

@Composable
fun Course(course: Course = Course.getCourses()[0]) {
    Box(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .background(
                shape = RoundedCornerShape(22.dp),
                brush = Brush.horizontalGradient(listOf(Color.White, Cream), startX = 100f)
            )
            .border(border = BorderStroke(2.dp, Cream), shape = RoundedCornerShape(22.dp))
            .clip(RoundedCornerShape(22.dp))
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {


            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = course.name,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = course.price,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Image(
                ImageBitmap.imageResource(course.image),
                contentDescription = course.name,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true, showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
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

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PopularCoursesPreview() {
    LearningPortalTheme {
        PopularCourses()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CoursePreview() {
    LearningPortalTheme {
        Course()
    }
}
