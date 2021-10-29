package com.example.firstproject.Week

import androidx.lifecycle.ViewModel
import com.example.firstproject.Week.Week

class WeekViewModel : ViewModel() {

    var myList = mutableListOf(
        Week(1),
        Week(2),
        Week(3),
        Week(4),
        Week(5),
    )
}