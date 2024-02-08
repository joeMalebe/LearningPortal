package com.example.learningportal.data

import androidx.compose.ui.graphics.Color
import com.example.learningportal.R
import com.example.learningportal.ui.theme.Blue
import com.example.learningportal.ui.theme.Cyan
import com.example.learningportal.ui.theme.Orange
import com.example.learningportal.ui.theme.Pink
import com.example.learningportal.ui.theme.Pink40
import com.example.learningportal.ui.theme.Purple40
import com.example.learningportal.ui.theme.PurpleGrey40

data class CourseCategory(val id: Int, val name: String, val image: Int, val backgroundColor: Color = Color.White) {
    companion object {
        fun getCourseCategories(): List<CourseCategory> {
            return listOf(
                CourseCategory(1, "Developing", R.drawable.btn_1, Cyan),
                CourseCategory(2, "Designing", R.drawable.btn_2, Purple40),
                CourseCategory(3, "AL and ML", R.drawable.btn_3, Pink),
                CourseCategory(4, "Explore", R.drawable.btn_4, Blue),
                CourseCategory(1, "Developing", R.drawable.btn_1, Orange),
                CourseCategory(3, "Cooking and cleaning", R.drawable.btn_3, PurpleGrey40),
                CourseCategory(1, "Public communication", R.drawable.btn_2, Pink40),
            )
        }
    }
}
