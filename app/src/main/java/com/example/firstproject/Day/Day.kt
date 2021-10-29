package com.example.firstproject.Day

import com.example.firstproject.MyCalender
import com.example.firstproject.Week.Week
import java.util.*

data class Day ( private val date : Date  = Date()) : MyCalender{
     val dateStr  = super.getDate(date)+ " " +super.getDayOfTheWeek(date)



}


