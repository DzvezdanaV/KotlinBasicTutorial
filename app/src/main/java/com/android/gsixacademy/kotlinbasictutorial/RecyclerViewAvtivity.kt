package com.android.gsixacademy.kotlinbasictutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recyclerview.*
import java.util.ArrayList
import com.android.gsixacademy.kotlinbasictutorial.CarsAdapter as CarsAdapter

class RecyclerViewAvtivity: AppCompatActivity() {


    var listCars: ArrayList<Car> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        listCars.add(Car("Mclaren", "MC Description", R.drawable.mclaren))
        listCars.add(Car("Honda", "Honda Description", R.drawable.honda_nsx))
        listCars.add(Car("Jaguar", "Jaguar Description", R.drawable.jaguar_f))
        listCars.add(Car("Mercedes", "Mercedes Description", R.drawable.mercedes_amg))
        listCars.add(Car("Audi", "Audi Description", R.drawable.audi_r))
        listCars.add(Car("Maserati", "Maserati Description", R.drawable.maserati_granturismo))
        listCars.add(Car("Nissan", "Nissan Description", R.drawable.nissan))



        for (number in 0..100) {
            listCars.add(Car("Nissan", "Nissan Description $number", R.drawable.nissan))


        }




        var carsAdapter: CarsAdapter = CarsAdapter (listCars)
        recycler_view_activities.adapter = carsAdapter

    }

}