package com.example.firstproject

import androidx.lifecycle.ViewModel

class WeekViewModel : ViewModel() {

    var myList = mutableListOf(
        Week(1),
        Week(2),
        Week(3),
        Week(4),
        Week(5),
    )
}