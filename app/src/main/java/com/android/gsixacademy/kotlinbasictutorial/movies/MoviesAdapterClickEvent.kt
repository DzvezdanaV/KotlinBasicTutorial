package com.android.gsixacademy.kotlinbasictutorial.movies

import com.android.gsixacademy.kotlinbasictutorial.models.MovieResult


sealed class MoviesAdapterClickEvent {

data class MoviesAdapterItemClicked( var movieResult: MovieResult ): MoviesAdapterClickEvent()
}