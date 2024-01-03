package com.example.learningportal

data class CourseCategory(val id: Int, val name: String, val image: Int) {
    companion object {
        fun getCourseCategories(): List<CourseCategory> {
            return listOf(
                CourseCategory(1, "Developing", R.drawable.btn_1),
                CourseCategory(2, "Designing", R.drawable.btn_2),
                CourseCategory(3, "AL and ML", R.drawable.btn_3),
                CourseCategory(4, "Explore", R.drawable.btn_4)
            )
        }
    }
}
