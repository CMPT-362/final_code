package com.xyz.myhealth.services

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar

object TimeService {
    fun getCurrentTime():String{
        val c: Calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm aa")
        return sdf.format(c)
    }
}