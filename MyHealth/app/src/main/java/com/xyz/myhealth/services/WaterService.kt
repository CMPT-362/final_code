package com.xyz.myhealth.services

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.schema.DrinkWater

private const val TAG = "DRINK_WATER"

object WaterService {
    fun addDrinkWater(){
        val database : DatabaseReference = FirebaseDatabase.getInstance().getReference("DrinkWater")
        val newDrinkTime = DrinkWater(TimeService.getCurrentTime())
        database.push().setValue(newDrinkTime).addOnSuccessListener {
            Log.i(TAG,"DrinkWater was Saved")
        }.addOnFailureListener {
            Log.e(TAG,"DrinkWater was not Saved")
        }
    }
}