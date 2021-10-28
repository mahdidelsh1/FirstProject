package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment  = supportFragmentManager.findFragmentById(R.id.frameLayout)
        if (fragment == null){
            val fragment = WeekFragment()
            supportFragmentManager.beginTransaction().add(R.id.frameLayout , fragment).commit()

        }
    }
}


//    private var simpleCallBack = object : ItemTouchHelper.SimpleCallback(
//        ItemTouchHelper.UP.or(ItemTouchHelper.DOWN),ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)){
//        override fun onMove(
//            recyclerView: RecyclerView,
//            viewHolder: RecyclerView.ViewHolder,
//            target: RecyclerView.ViewHolder
//        ): Boolean {
//            return true
//        }
//
//        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//
//            val position = viewHolder.bindingAdapterPosition
//            when(direction){
//                ItemTouchHelper.LEFT -> {
//                    displayList.removeAt(position)
//                    viewHolder.bindingAdapter?.notifyItemRemoved(position)
//                }
//            }
//
//        }
//
//    }

