package com.example.learningportal.data

import androidx.annotation.DrawableRes
import com.example.learningportal.R

data class Course(val id: String, val name: String, @DrawableRes val image:  Int, val courseCategoryId: String, val price: String, @DrawableRes val backgroundImg: Int ) {
    companion object {
        fun getCourses(): List<Course> {
            return listOf(
                Course("1", "Deep Reinforcement Learning in Python", R.drawable.ic_1, "1", "R100", R.drawable.bg_1),
                Course("2", "Learn and Understand NodeJS", R.drawable.ic_2, "2", "R250", R.drawable.bg_2),
                Course("3", "iOS & Swift - The Complete iOS ", R.drawable.ic_4, "3", "R260", R.drawable.bg_3),
                Course("4", "Java 17 Masterclass: Start Coding in 2024", R.drawable.ic_3, "4", "R100", R.drawable.bg_4),
                Course("5", "GREENsters, Inc.: Ecological Transition", R.drawable.ic_5, "4", "R400", R.drawable.bg_5),
                Course("2", "Sustainable Urban Development", R.drawable.ic_2, "2", "R250", R.drawable.bg_1),
                Course("3", "Bordeaux and blueprints", R.drawable.ic_4, "3", "R260", R.drawable.bg_2),

                )
        }
    }
}