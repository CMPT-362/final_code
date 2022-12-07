package com.xyz.myhealth.schema

data class UserProfile(
    val name: String? = null,
    val email: String? = null,
    val age: Int? = null,
    val calorieGoal: Float? = null,
    val currentWeight: Float? = null,
    val timeStamp: String? = null,
)
