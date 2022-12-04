package com.xyz.myhealth.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xyz.myhealth.databinding.ActivityManualEntryBinding
import com.xyz.myhealth.services.CalorieService

class ManualEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManualEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManualEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onManualEntrySaveClicked()
        onManualEntryCancelClicked()
    }

    private fun onManualEntrySaveClicked(){
        binding.manualEntrySaveButton.setOnClickListener{

            CalorieService.addManualEntry(
                binding.activityPerformed.text.toString(),
                binding.activityDuration.text.toString().toInt(),
                binding.activityCaloriesLost.text.toString().toFloat(),
                binding.activityHeartRate.text.toString().toFloat()
            )

            finish()
        }
    }

    private fun onManualEntryCancelClicked(){
        binding.manualEntryCancelButton.setOnClickListener{
            finish()
        }
    }
}