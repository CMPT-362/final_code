package com.xyz.myhealth.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xyz.myhealth.R

class ManualEntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_entry)
    }

    fun onManualEntrySaveClicked(view:View){
        finish()
    }

    fun onManualEntryCancelClicked(view:View){
        finish()
    }
}