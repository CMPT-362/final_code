package com.xyz.myhealth.services

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.schema.CalorieEntry
import com.xyz.myhealth.schema.CalorieIntake

private const val CALORIE_INTAKE_TAG = "CALORIE_INTAKE"
private const val CALORIE_ENTRY_TAG = "CALORIE_ENTRY"

object CalorieService {

    fun addCalorieEntry(foodItem: String, foodCalorie: Float){
        val database : DatabaseReference = FirebaseDatabase.getInstance().getReference("CalorieIntake")
        val newCalorieIntake = CalorieIntake(foodItem,foodCalorie, TimeService.getCurrentTime())
        database.push().setValue(newCalorieIntake).addOnSuccessListener {
            Log.i(CALORIE_INTAKE_TAG,"CalorieIntake was Saved")

        }.addOnFailureListener {
            Log.e(CALORIE_INTAKE_TAG,"CalorieIntake was not Saved")
        }
    }

    fun addManualEntry(activityPerformed: String, activityDuration: Int, activityCaloriesLost: Float, activityHeartRate: Float,){
        val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("CalorieEntry")
        val newCalorieEntry = CalorieEntry(activityPerformed, activityDuration, activityCaloriesLost, activityHeartRate, TimeService.getCurrentTime())
        database.push().setValue(newCalorieEntry).addOnSuccessListener {
            Log.i(CALORIE_ENTRY_TAG,"CalorieEntry was Saved")
        }.addOnFailureListener {
            Log.e(CALORIE_ENTRY_TAG,"CalorieEntry was Saved")
        }
    }
}