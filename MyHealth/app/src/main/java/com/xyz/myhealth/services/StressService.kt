package com.xyz.myhealth.services

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.schema.Stress

private const val STRESS_TAG = "STRESS"

object StressService {
    fun addStressEntry(email:String, stressValue: Int){
        val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("Stress")
        val newStress = Stress(stressValue, TimeService.getTimeStamp())
        database.child(email).push().setValue(newStress).addOnSuccessListener {
            val db : DatabaseReference= FirebaseDatabase.getInstance().getReference("DailyUserData")
            db.child(email).get().addOnSuccessListener {
                if(it.exists()){
                    if(stressValue < 34){
                        DailyUserDataService.addOrUpdateDailyUserData(
                            email,
                            it.child("calorieIntake").value.toString().toFloat(),
                            it.child("calorieLost").value.toString().toFloat(),
                            it.child("netCalorieGain").value.toString().toFloat(),
                            it.child("glassOfWater").value.toString().toInt(),
                            "low"
                        )
                    }
                    else if(stressValue < 67){
                        DailyUserDataService.addOrUpdateDailyUserData(
                            email,
                            it.child("calorieIntake").value.toString().toFloat(),
                            it.child("calorieLost").value.toString().toFloat(),
                            it.child("netCalorieGain").value.toString().toFloat(),
                            it.child("glassOfWater").value.toString().toInt(),
                            "mid"
                        )
                    } else {
                        DailyUserDataService.addOrUpdateDailyUserData(
                            email,
                            it.child("calorieIntake").value.toString().toFloat(),
                            it.child("calorieLost").value.toString().toFloat(),
                            it.child("netCalorieGain").value.toString().toFloat(),
                            it.child("glassOfWater").value.toString().toInt(),
                            "high"
                        )
                    }
                }
                Log.i(USER_PROFILE_TAG,"Stress was Read")
            }.addOnFailureListener {
                Log.e(USER_PROFILE_TAG,"Stress was not Read")
            }
            Log.i(STRESS_TAG,"Stress was Saved")
        }.addOnFailureListener {
            Log.e(STRESS_TAG,"Stress was Saved")
        }
    }
}