package com.android.gsixacademy.kotlinbasictutorial

import com.android.gsixacademy.kotlinbasictutorial.models.Car

sealed class CarsAdapterClickEvent {

data class CarsAdapterItemClicked( var car: Car): CarsAdapterClickEvent()
}