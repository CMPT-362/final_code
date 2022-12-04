package com.xyz.myhealth.services

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.schema.DailyUserData
import com.xyz.myhealth.schema.UserProfile

private const val USER_PROFILE_TAG = "USER_PROFILE"
private const val DAILY_USER_DATA_TAG = "DAILY_USER_DATA"

object UserService {

    fun addUserProfile(name: String, email: String, age: Int, calorieGoal:Float, currentWeight:Float){
        val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserProfiles")
        val newUserProfile = UserProfile(name,email,age,calorieGoal,currentWeight, TimeService.getCurrentTime())
        database.push().setValue(newUserProfile).addOnSuccessListener {
            Log.i(USER_PROFILE_TAG,"UserProfile was Saved")
        }.addOnFailureListener {
            Log.e(USER_PROFILE_TAG,"UserProfile was Saved")
        }
    }

    fun addDailyUserData(){
        val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("DailyUserData")
        val newDailyUserData = DailyUserData(0F,0F, 0F, 0, "No data")
        database.push().setValue(newDailyUserData).addOnSuccessListener {
            Log.i(DAILY_USER_DATA_TAG,"DailyUserData was Saved")
        }.addOnFailureListener {
            Log.e(DAILY_USER_DATA_TAG,"DailyUserData was Saved")
        }
    }
}