package com.xyz.myhealth.services

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.schema.CalorieIntake

private const val CALORIE_ENTRY_TAG = "CALORIE_ENTRY"

object CalorieService {

    fun addCalorieEntry(foodItem: String, foodCalorie: Float) {
        val database : DatabaseReference = FirebaseDatabase.getInstance().getReference("CalorieIntake")
        val newCalorieIntake = CalorieIntake(foodItem,foodCalorie)
        database.push().setValue(newCalorieIntake).addOnSuccessListener {
            Log.i(CALORIE_ENTRY_TAG,"CalorieEntry was Saved")

        }.addOnFailureListener {
            Log.e(CALORIE_ENTRY_TAG,"CalorieEntry was not Saved")
        }
    }
}