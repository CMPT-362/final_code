package com.xyz.myhealth.schema

import java.time.LocalTime

data class Stress(
    val stressValue: Int? = null,
    val time: LocalTime? = null,
)
