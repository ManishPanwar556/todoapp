package com.manish.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.Callback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_2.*
import kotlinx.android.synthetic.main.textview.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var list:List<todo>


    val db by lazy {
        Room.databaseBuilder(
            this,
            appdatabase::class.java, "user.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fb.setOnClickListener(this)
        list=db.dao().getalllist()
        rv.layoutManager=LinearLayoutManager(this)
        rv.adapter=todoadapter(list)

        val itemTouchHelpercallback=object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos=viewHolder.adapterPosition

                if(direction==ItemTouchHelper.LEFT)
                {
                    db.dao().delete(list.get(pos))
                }
                else if(direction==ItemTouchHelper.RIGHT)
                {
                    db.dao().delete(list.get(pos))
                }
                var adapter:todoadapter= todoadapter(list)
                adapter.remove(viewHolder)

            }

        }
        val itemtouchhelper=ItemTouchHelper(itemTouchHelpercallback)
        itemtouchhelper.attachToRecyclerView(rv)








    }



    override fun onClick(v: View) {
         var i=Intent(this,Main_Activity2::class.java)
         startActivity(i)
     }




}
