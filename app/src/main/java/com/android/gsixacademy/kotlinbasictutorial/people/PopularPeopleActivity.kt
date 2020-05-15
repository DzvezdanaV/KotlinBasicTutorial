package com.android.gsixacademy.kotlinbasictutorial.people

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.kotlinbasictutorial.R
import com.android.gsixacademy.kotlinbasictutorial.api.ServiceBuilder
import com.android.gsixacademy.kotlinbasictutorial.api.TheMovieDbApi
import com.android.gsixacademy.kotlinbasictutorial.models.PopularPeople
import com.android.gsixacademy.kotlinbasictutorial.movies.MoviesAdapter
import kotlinx.android.synthetic.main.activity_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularPeopleActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)

        val request = ServiceBuilder.buildService(TheMovieDbApi::class.java)

        val call = request.getPopularPeople("")

        call.enqueue(object : Callback<PopularPeople> {
            override fun onResponse(call: Call<PopularPeople>, response: Response<PopularPeople>) {
                if (response.isSuccessful) {

                    val popularPeople = response.body()

                    val peopleList = popularPeople?.results


                    if (peopleList != null) {
                        var peopleAdapter = PeopleAdapter (peopleList){}
                        recycler_view_movies.adapter = peopleAdapter
                    }
                }

            }
            override fun onFailure(call: Call<PopularPeople>, t: Throwable) {
                // show the error
            }
        })



    }
}





