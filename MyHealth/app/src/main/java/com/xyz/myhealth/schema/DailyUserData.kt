package com.xyz.myhealth.schema

data class DailyUserData(
    val calorieIntake: Float? = null,
    val calorieLost: Float? = null,
    val netCalorieGain: Float? = null,
    val glassOfWater: Int? =null,
    val stress : String? = null,
)