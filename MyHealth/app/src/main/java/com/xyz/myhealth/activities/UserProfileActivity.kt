package com.xyz.myhealth.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xyz.myhealth.databinding.ActivityUserProfileBinding
import com.xyz.myhealth.services.UserService

/**
 * This activity is for creating or editing
 * information about User Profile
 */
class UserProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onUserProfileSaveClick()
        onUserProfileCancelClick()
    }

    private fun onUserProfileSaveClick(){
        binding.userProfileSaveButton.setOnClickListener{
            UserService.addUserProfile(
                binding.profileName.text.toString(),
                binding.profileEmail.text.toString(),
                binding.profileAge.text.toString().toInt(),
                binding.profileCalorieGoal.text.toString().toFloat(),
                binding.profileCurrentWeight.text.toString().toFloat()
            )
            finish()
        }
    }

    private fun onUserProfileCancelClick(){
        binding.userProfileCancelButton.setOnClickListener{
            finish()
        }
    }
}