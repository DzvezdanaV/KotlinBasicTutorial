package com.android.gsixacademy.kotlinbasictutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class RecyclerViewAvtivity: AppCompatActivity() {


    var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity", "CalculatorActivity", "ToDoListActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}