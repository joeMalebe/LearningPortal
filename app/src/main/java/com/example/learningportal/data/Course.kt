package com.example.learningportal.data

import androidx.annotation.DrawableRes
import com.example.learningportal.R

data class Course(val id: String, val name: String, @DrawableRes val image:  Int, val courseCategoryId: String, val price: String, @DrawableRes val backgroundImg: Int ) {
    companion object {
        fun getCourses(): List<Course> {
            return listOf(
                Course("1", "Developing", R.drawable.ic_1, "1", "R100", R.drawable.bg_1),
                Course("2", "Designing", R.drawable.ic_2, "2", "R250", R.drawable.bg_2),
                Course("3", "AL and ML", R.drawable.ic_3, "3", "R260", R.drawable.bg_3),
                Course("4", "Explore", R.drawable.ic_4, "4", "R100", R.drawable.bg_4),
                Course("5", "Explore", R.drawable.ic_5, "4", "R400", R.drawable.bg_5),
            )
        }
    }
}