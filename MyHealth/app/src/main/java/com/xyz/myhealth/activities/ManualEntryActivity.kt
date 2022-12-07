package com.xyz.myhealth.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.databinding.ActivityManualEntryBinding
import com.xyz.myhealth.services.CalorieService
import com.xyz.myhealth.services.DailyUserDataService
import com.xyz.myhealth.services.USER_PROFILE_TAG

class ManualEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManualEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManualEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onManualEntrySaveClicked("w@w")
        onManualEntryCancelClicked()
    }

    private fun onManualEntrySaveClicked(email:String){
        binding.manualEntrySaveButton.setOnClickListener{

            CalorieService.addManualEntry(
                "w@w",
                binding.activityPerformed.text.toString(),
                binding.activityDuration.text.toString().toInt(),
                binding.activityCaloriesLost.text.toString().toFloat(),
                binding.activityHeartRate.text.toString().toFloat()
            )
            val db : DatabaseReference = FirebaseDatabase.getInstance().getReference("DailyUserData")
            db.child(email).get().addOnSuccessListener {
                if(it.exists()){
                    DailyUserDataService.addOrUpdateDailyUserData(
                        email,
                        it.child("calorieIntake").value.toString().toFloat(),
                        it.child("calorieLost").value.toString().toFloat()+binding.activityCaloriesLost.text.toString().toFloat(),
                        it.child("netCalorieGain").value.toString().toFloat()-binding.activityCaloriesLost.text.toString().toFloat(),
                        it.child("glassOfWater").value.toString().toInt()+1,
                        it.child("stress").value.toString()
                    )

                }
                Log.i(USER_PROFILE_TAG,"Stress was Read")
            }.addOnFailureListener {
                Log.e(USER_PROFILE_TAG,"Stress was not Read")
            }
            finish()
        }
    }

    private fun onManualEntryCancelClicked(){
        binding.manualEntryCancelButton.setOnClickListener{
            finish()
        }
    }
}