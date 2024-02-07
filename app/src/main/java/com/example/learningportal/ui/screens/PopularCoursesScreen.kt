package com.example.learningportal.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningportal.R
import com.example.learningportal.data.Course
import com.example.learningportal.ui.theme.Cream


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularCoursesScreen() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Row {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    modifier = Modifier.size(48.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        bitmap = ImageBitmap.imageResource(id = R.drawable.back),
                        contentDescription = "menu",
                        modifier = Modifier
                            .padding(12.dp)
                    )

                }
            }

            /*TODO*/
        })
    }) { paddingValues ->
        LazyColumn(Modifier.padding(paddingValues)) {
            items(Course.getCourses()) {
                Course(course = it)
            }
        }
    }
}

@Composable
private fun Course(course: Course = Course.getCourses()[0]) {
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PopularCoursesScreenPreview() {
    PopularCoursesScreen()
}

