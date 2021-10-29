package com.example.firstproject.Week

import com.example.firstproject.MyCalender
import java.text.SimpleDateFormat
import java.util.*

data class Week (var WeekNumber : Int , var date : Date = Date())  : MyCalender{

    var realDate : String = super.getDate(date)


}