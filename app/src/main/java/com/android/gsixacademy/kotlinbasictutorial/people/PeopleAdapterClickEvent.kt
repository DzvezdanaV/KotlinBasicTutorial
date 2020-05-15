package com.android.gsixacademy.kotlinbasictutorial.people

import com.android.gsixacademy.kotlinbasictutorial.models.MovieResult
import com.android.gsixacademy.kotlinbasictutorial.models.PersonResult


sealed class PeopleAdapterClickEvent {

data class PeopleAdapterItemClicked( val personResult: PersonResult ): PeopleAdapterClickEvent()
}