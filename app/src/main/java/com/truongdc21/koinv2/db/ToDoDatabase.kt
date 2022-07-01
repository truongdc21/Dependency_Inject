package com.truongdc21.koinv2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.truongdc21.koinv2.model.ToDo

@Database(entities = [ToDo::class], version = 1, exportSchema = false)

abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}