package com.android.gsixacademy.kotlinbasictutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.gsixacademy.kotlinbasictutorial.movies.PopularMoviesActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity", "CalculatorActivity", "ToDoListActivity", "RecyclerViewActivity",
        "LoginActivity", "UserSignedInActivity", "CarDetailsActivity", "PopularMoviesActivity" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().load("https://pbs.twimg.com/profile_images/640983070166904832/30NhBuJC_400x400.jpg").into(image_view_background)


        var activitiesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,listActivities)
        list_view_activities.adapter = activitiesAdapter

        list_view_activities.setOnItemClickListener { adapterView, view, i, l ->

            var className = listActivities[i]

//            startActivity(Intent(applicationContext,RelativeLayoutActivity::class.java))

            when (className) {
                "RelativeLayoutActivity" -> startActivity(Intent(applicationContext, RelativeLayoutActivity::class.java))
                "CalculatorActivity" -> startActivity(Intent(applicationContext, CalculatorActivity::class.java))
                "ToDoListActivity" -> startActivity(Intent(applicationContext, ToDoListActivity::class.java))
                "RecyclerViewActivity" -> startActivity(Intent(applicationContext, RecyclerViewActivity::class.java))
                "LoginActivity" -> startActivity(Intent(applicationContext, LoginActivity::class.java))
                "UserSignedInActivity" -> startActivity(Intent(applicationContext, UserSignedInActivity::class.java))
                "CarDetailsActivity" -> startActivity(Intent(applicationContext, CarDetailsActivity::class.java))
                "PopularMoviesActivity" -> startActivity(Intent(applicationContext, PopularMoviesActivity::class.java))

            }

            Toast.makeText(applicationContext, className, Toast.LENGTH_LONG).show()



        }
    }
}
