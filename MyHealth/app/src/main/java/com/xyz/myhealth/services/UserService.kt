package com.xyz.myhealth.services

import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.schema.UserProfile

private const val USER_TAG = "USER"

object UserService {

    fun addUserProfile(name: String, email: String, age: Int, calorieGoal:Float, currentWeight:Float){
        val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("UserProfiles")
        val newUserProfile = UserProfile(name,email,age,calorieGoal,currentWeight)
        database.push().setValue(newUserProfile).addOnSuccessListener {
            Log.i(USER_TAG,"UserProfile was Saved")
        }.addOnFailureListener {
            Log.e(USER_TAG,"UserProfile was Saved")
        }
    }
}