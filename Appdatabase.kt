package com.manish.todoapp

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [todo::class],version = 2)
abstract class appdatabase: RoomDatabase(){
    abstract fun dao():dao
}