package com.xyz.myhealth.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.xyz.myhealth.R
import com.xyz.myhealth.databinding.ActivityCalorieEntryBinding
import com.xyz.myhealth.schema.CalorieIntake
import com.xyz.myhealth.schema.UserProfile
import com.xyz.myhealth.services.CalorieService

class CalorieEntryActivity : AppCompatActivity() {

    private lateinit var foodItem: TextView
    private lateinit var foodCalorie: TextView
    private lateinit var binding: ActivityCalorieEntryBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalorieEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onCalorieEntrySaveClicked()
        onCalorieEntryCancelClicked()
    }

    private fun onCalorieEntrySaveClicked() {
        binding.calorieEntrySaveButton.setOnClickListener{

            CalorieService.addCalorieEntry(
                binding.foodItem.text.toString(),
                binding.foodCalorie.text.toString().toFloat()
            )
            finish()
        }
    }

    private fun onCalorieEntryCancelClicked() {
        binding.calorieEntryCancelButton.setOnClickListener{
            finish()
        }
    }
}