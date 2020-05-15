package com.android.gsixacademy.kotlinbasictutorial.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.gsixacademy.kotlinbasictutorial.R
import com.android.gsixacademy.kotlinbasictutorial.api.ServiceBuilder
import com.android.gsixacademy.kotlinbasictutorial.api.TheMovieDbApi
import com.android.gsixacademy.kotlinbasictutorial.models.PopularMovies
import com.android.gsixacademy.kotlinbasictutorial.models.PopularPeople
import com.android.gsixacademy.kotlinbasictutorial.movies.MoviesAdapter
import com.android.gsixacademy.kotlinbasictutorial.people.PeopleAdapter
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPeopleActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        button_search.setOnClickListener {

            val request = ServiceBuilder.buildService(TheMovieDbApi::class.java)

            val call = request.searchPeople("8dd3a40cdacd660d79bce7c46bad942e", edit_text_search.text.toString())


            call.enqueue(object : Callback<PopularPeople> {
                override fun onResponse(
                    call: Call<PopularPeople>,
                    response: Response<PopularPeople>
                ) {
                    if (response.isSuccessful) {

                        val popularPeople = response.body()

                        val peopleList = popularPeople?.results



                        if (peopleList != null) {
                            var peopleAdapter = PeopleAdapter(peopleList) {}

                            recycler_view_search.layoutManager =
                                GridLayoutManager(applicationContext, 2)
                            recycler_view_search.adapter = peopleAdapter

                        }
                    }

                }


                override fun onFailure(call: Call<PopularPeople>, t: Throwable) {
                    // show the error
                }

            })
        }
    }

}