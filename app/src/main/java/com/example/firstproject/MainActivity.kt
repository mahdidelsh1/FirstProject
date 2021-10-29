package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstproject.Day.DayFragment
import com.example.firstproject.Week.WeekFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment  = supportFragmentManager.findFragmentById(R.id.frameLayout)
        if (fragment == null){
//            val fragment = WeekFragment()
            val fragment = DayFragment()
            supportFragmentManager.beginTransaction().add(R.id.frameLayout , fragment).commit()

        }
    }
}




