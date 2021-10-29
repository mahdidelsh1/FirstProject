package com.example.firstproject

import java.text.SimpleDateFormat
import java.util.*

interface MyCalender {


    open fun gregorian_to_jalali(gy: Int, gm: Int, gd: Int): IntArray {
        var g_d_m: IntArray = intArrayOf(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
        var gy2: Int = if (gm > 2) (gy + 1) else gy
        var days: Int = 355666 + (365 * gy) + ((gy2 + 3) / 4).toInt() - ((gy2 + 99) / 100).toInt() + ((gy2 + 399) / 400).toInt() + gd + g_d_m[gm - 1]
        var jy: Int = -1595 + (33 * (days / 12053).toInt())
        days %= 12053
        jy += 4 * (days / 1461).toInt()
        days %= 1461
        if (days > 365) {
            jy += ((days - 1) / 365).toInt()
            days = (days - 1) % 365
        }
        var jm: Int; var jd: Int;
        if (days < 186) {
            jm = 1 + (days / 31).toInt()
            jd = 1 + (days % 31)
        } else {
            jm = 7 + ((days - 186) / 30).toInt()
            jd = 1 + ((days - 186) % 30)
        }
        return intArrayOf(jy, jm, jd)
    }

    fun getDate(date: Date) : String{
        val sdf  = SimpleDateFormat("yyyy MM dd")
        val year : String = sdf.format(date).toString().subSequence(0,4) as String
        val month : String = sdf.format(date).toString().subSequence(5,7) as String
        val day : String = sdf.format(date).toString().subSequence(8,10) as String

        val shamsi : IntArray = gregorian_to_jalali(year.toInt() , month.toInt()  , day.toInt())

        return shamsi[0].toString()+"/"+shamsi[1].toString()+"/"+shamsi[2].toString()
    }


    fun getDayOfTheWeek(date : Date) : String{

      return  when(date.day){
            0->"یک شنبه "
            1->"دو شنبه "
            2->"سه شنبه "
            3->"چهار شنبه "
            4->"پنج شنبه "
            5->" جمعه  "
            6->"  شنبه "
            else -> ""
        }.trim()

    }


}