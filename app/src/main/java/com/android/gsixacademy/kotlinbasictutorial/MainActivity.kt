package com.android.gsixacademy.kotlinbasictutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity", "CalculatorActivity", "ToDoListActivity", "RecyclerViewActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().load("https://i.pinimg.com/564x/f3/4d/1b/f34d1b622de7c23abbfc443fc4648243.jpg").into(image_view_background)


        var activitiesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,listActivities)
        list_view_activities.adapter = activitiesAdapter

        list_view_activities.setOnItemClickListener { adapterView, view, i, l ->

            var className = listActivities[i]

//            startActivity(Intent(applicationContext,RelativeLayoutActivity::class.java))

            when (className) {
                "RelativeLayoutActivity" -> startActivity(Intent(applicationContext, RelativeLayoutActivity::class.java))
                "CalculatorActivity" -> startActivity(Intent(applicationContext, CalculatorActivity::class.java))
                "ToDoListActivity" -> startActivity(Intent(applicationContext, ToDoListActivity::class.java))
                "RecyclerViewActivity" -> startActivity(Intent(applicationContext, RecyclerViewAvtivity::class.java))
            }

            Toast.makeText(applicationContext, className, Toast.LENGTH_LONG).show()



        }
    }
}
