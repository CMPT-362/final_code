package com.xyz.myhealth.schema

data class CalorieEntry(
    val activityPerformed: String? = null,
    val activityDuration: Int? = null,
    val activityCalorieLost: Float? = null,
    val activityHeartRate: Float? = null,
    val timeStamp: String? = null,
)