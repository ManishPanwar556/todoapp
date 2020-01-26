package com.manish.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_2.*

class Main_Activity2 : AppCompatActivity(),View.OnClickListener{
    val obj:MainActivity=MainActivity()
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
        setContentView(R.layout.activity_main_2)
        btn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        db.dao().insert(todo(edt1.text.toString(),edt2.text.toString(),edt3.toString()))
        startActivity(Intent(this,MainActivity::class.java))
    }
}
