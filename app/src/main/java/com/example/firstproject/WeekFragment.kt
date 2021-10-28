package com.example.firstproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val Tag = "Test"

class WeekFragment : Fragment() {

    private lateinit var weekRecyclerView : RecyclerView
    private lateinit var addBTN : FloatingActionButton



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_week,container,false)
        //recycler view :
        weekRecyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        weekRecyclerView.layoutManager = LinearLayoutManager(context)

        var myList = mutableListOf(
            Week(1),
            Week(2),
            Week(3),
            Week(4),
            Week(5),


            )

        var myAdapter  : WeekAdapter = WeekAdapter(myList)
        weekRecyclerView.adapter = myAdapter
        Log.d(Tag , "1 : $weekRecyclerView")

        //floating button :
        addBTN = view.findViewById(R.id.Add)
        addBTN.setOnClickListener {

            val weekNumber = myList[myList.lastIndex].WeekNumber + 1
            val newWeek : Week = Week(weekNumber)
            myList.add(newWeek)
            //tell da adapter new item inserted and where it inserted
            myAdapter.notifyItemInserted(myList.size)

        }
        return view
    }


    inner class WeekAdapter(var weeks  : MutableList<Week>) : RecyclerView.Adapter<WeekViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
            Log.d(Tag , "2")

            val view = layoutInflater.inflate(R.layout.week_item, parent, false)
            return WeekViewHolder(view)
        }

        override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
            Log.d(Tag , "3")

            val week : Week = weeks[position]
            holder.bind(week)

        }

        override fun getItemCount() = weeks.size





    }

    inner class WeekViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val weekTV : TextView = view.findViewById(R.id.weekTV)
        val dateTV : TextView = view.findViewById(R.id.dateTV)


        fun bind(week: Week) {
            Log.d(Tag , "4")
            val weekText : String ="  هفته ی  " +  week.WeekNumber.toString()
            weekTV.text = weekText
            dateTV.text = week.date.toString()
        }

    }


}