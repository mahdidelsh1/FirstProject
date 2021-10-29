package com.example.firstproject.Day

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstproject.R
import com.example.firstproject.SwipeToDeleteCallback
import com.example.firstproject.Week.WeekViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val dayViewModel : DayViewModel by lazy {
        ViewModelProvider(this)[DayViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val view  = inflater.inflate(R.layout.fragment_day, container, false)

        //setting up recycler view :
        val recyclerView : RecyclerView =view.findViewById(R.id.dayRecyclerView)
        val adapter = DayAdapter(dayViewModel.days)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter


        //Add Day Btn  :
        val addDayBTN  = view.findViewById<FloatingActionButton>(R.id.AddDayBTN)
        addDayBTN.setOnClickListener {

            if (dayViewModel.days.size > 6 ){
                Toast.makeText(view.context , "Can't add Days Week has only 7 Days" , Toast.LENGTH_SHORT).show()
            }
            else{
                val day = Day()
                if (dayViewModel.days.size == 0 ){

                    dayViewModel.days.add(day)
                    adapter.notifyItemInserted(dayViewModel.days.size)
                }
                else {
                    if (dayViewModel.days[dayViewModel.days.size - 1 ].dateStr != day.dateStr){
                    }
                    else{
                        Toast.makeText(view.context , "You have already added a Day Today", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }


        //delete  :
        val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.bindingAdapterPosition

                Toast.makeText(view.context , "${dayViewModel.days[pos].dateStr} is Deleted" , Toast.LENGTH_SHORT).show()

                dayViewModel.days.removeAt(pos)
                adapter.notifyItemRemoved(pos)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)


        return view
    }

    inner class DayAdapter(var Daylist: MutableList<Day>) : RecyclerView.Adapter<DayAdapter.DayViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
            val view  = LayoutInflater.from(parent.context).inflate(R.layout.day_item , parent , false)
            return DayViewHolder(view)
        }

        override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
            holder.dayTV.text = Daylist[position].dateStr
        }

        override fun getItemCount() = Daylist.size

        inner class DayViewHolder (view : View): RecyclerView.ViewHolder(view){
            val dayTV = view.findViewById<TextView>(R.id.DayTV)

            init {
                itemView.setOnClickListener {
                    Toast.makeText(view.context , " You selected ${Daylist[position].dateStr}", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }



    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}