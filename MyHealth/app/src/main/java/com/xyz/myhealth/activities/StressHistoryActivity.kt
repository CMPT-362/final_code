package com.xyz.myhealth.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.xyz.myhealth.R
import com.xyz.myhealth.services.USER_PROFILE_TAG

class StressHistoryActivity : AppCompatActivity() {
    lateinit var lineGraphView: GraphView
    var array: Array<DataPoint> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stress_history)

        lineGraphView = findViewById(R.id.idGraphView)

        readData()

        val series: LineGraphSeries<DataPoint> = LineGraphSeries(array)
        lineGraphView.animate()
        lineGraphView.viewport.isScrollable = true
        lineGraphView.viewport.isScalable = true
        lineGraphView.viewport.setScrollableY(true)
        series.color = R.color.purple_200
        lineGraphView.addSeries(series)
    }

    private fun readData(){
        val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("Stress")
        database.child("w@w").get().addOnSuccessListener {
            for(ds in it.children){
                val stressValue = ds.child("stressValue").value.toString().toInt()

            }
            Log.i(USER_PROFILE_TAG,"Stress was Read")
        }.addOnFailureListener {
            Log.e(USER_PROFILE_TAG,"Stress was not Read")
        }
    }
}