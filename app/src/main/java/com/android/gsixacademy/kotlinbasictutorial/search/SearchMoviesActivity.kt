package com.android.gsixacademy.kotlinbasictutorial.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.kotlinbasictutorial.R
import com.android.gsixacademy.kotlinbasictutorial.api.ServiceBuilder
import com.android.gsixacademy.kotlinbasictutorial.api.TheMovieDbApi
import com.android.gsixacademy.kotlinbasictutorial.models.PopularMovies
import com.android.gsixacademy.kotlinbasictutorial.models.PopularPeople
import com.android.gsixacademy.kotlinbasictutorial.movies.MoviesAdapter
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchMoviesActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        button_search.setOnClickListener {


            val request = ServiceBuilder.buildService(TheMovieDbApi::class.java)

            val call = request.searchMovies("8dd3a40cdacd660d79bce7c46bad942e", edit_text_search.text.toString())


            call.enqueue(object : Callback<PopularMovies> {
                override fun onResponse(
                    call: Call<PopularMovies>,
                    response: Response<PopularMovies>
                ) {
                    if (response.isSuccessful) {

                        val popularMovies = response.body()

                        val moviesList = popularMovies?.results



                        if (moviesList != null) {
                            var moviesAdapter = MoviesAdapter(moviesList) {}
                            recycler_view_search.adapter = moviesAdapter

                        }
                    }

                }


                override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                    // show the error
                }

            })
        }
    }
}