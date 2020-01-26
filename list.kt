package com.manish.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class todo(


    val task:String,
    val date:String,
    val where:String,

    @PrimaryKey(autoGenerate = true)
    val id:Long=0L

)