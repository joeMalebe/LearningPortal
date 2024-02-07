package com.example.learningportal.data

import com.example.learningportal.R

data class CourseCategory(val id: Int, val name: String, val image: Int, val backgroundColor: Int = 0) {
    companion object {
        fun getCourseCategories(): List<CourseCategory> {
            return listOf(
                CourseCategory(1, "Developing", R.drawable.btn_1, R.color.teal_700),
                CourseCategory(2, "Designing", R.drawable.btn_2, R.color.purple_700),
                CourseCategory(3, "AL and ML", R.drawable.btn_3, R.color.teal_200),
                CourseCategory(4, "Explore", R.drawable.btn_4, R.color.purple_200)
            )
        }
    }
}
