package com.android.gsixacademy.kotlinbasictutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity", "CalculatorActivity", "ToDoListActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var activitiesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,listActivities)
        list_view_activities.adapter = activitiesAdapter

        list_view_activities.setOnItemClickListener { adapterView, view, i, l ->

            var className = listActivities[i]

//            startActivity(Intent(applicationContext,RelativeLayoutActivity::class.java))

            when (className) {
                "RelativeLayoutActivity" -> startActivity(Intent(applicationContext, RelativeLayoutActivity::class.java))
                "CalculatorActivity" -> startActivity(Intent(applicationContext, CalculatorActivity::class.java))
                "ToDoListActivity" -> startActivity(Intent(applicationContext, ToDoListActivity::class.java))
            }

            Toast.makeText(applicationContext, className, Toast.LENGTH_LONG).show()

        }
    }
}
