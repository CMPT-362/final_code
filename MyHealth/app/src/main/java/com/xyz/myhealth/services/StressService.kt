package com.xyz.myhealth.services

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.schema.Stress

private const val STRESS_TAG = "STRESS"

object StressService {
    fun addStressEntry(stressValue: Int){
        val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("Stress")
        val newStress = Stress(stressValue, TimeService.getCurrentTime())
        database.push().setValue(newStress).addOnSuccessListener {
            Log.i(STRESS_TAG,"Stress was Saved")

        }.addOnFailureListener {
            Log.e(STRESS_TAG,"Stress was Saved")
        }
    }
}