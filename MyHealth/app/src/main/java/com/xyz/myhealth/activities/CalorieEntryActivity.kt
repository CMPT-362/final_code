package com.xyz.myhealth.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.xyz.myhealth.R

class CalorieEntryActivity : AppCompatActivity() {

    private lateinit var foodItem: TextView
    private lateinit var foodCalorie: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorie_entry)

        //find views
        foodItem = findViewById(R.id.foodItem)
        foodCalorie = findViewById(R.id.foodCalorie)
    }

    fun saveFoodItem(){
        val foodItem : String = foodItem.text.toString()
        val foodCalorie : String = foodCalorie.text.toString()

        println("debug: foodItem is $foodItem")
        println("debug: foodCalorie is $foodCalorie")
    }

    fun onCalorieEntrySaveClicked(view: View) {
        saveFoodItem()
        Toast.makeText(this, "Food Item Saved", Toast.LENGTH_SHORT).show()
        finish()
    }

    fun onCalorieEntryCancelClicked(view: View) {
        Toast.makeText(this, "Food Item Cancelled", Toast.LENGTH_SHORT).show()
        finish()
    }
}