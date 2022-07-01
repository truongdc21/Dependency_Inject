package com.truongdc21.koinv2.di

import android.app.Application
import androidx.room.Room
import com.truongdc21.koinv2.db.ToDoDao
import com.truongdc21.koinv2.db.ToDoDatabase
import com.truongdc21.koinv2.utils.ConfigDb.DATABASE_NAME
import org.koin.dsl.module

val databseModule = module {

    single { provideToDoDataBase(get()) }

    single { provideToDoDao(get()) }
}

fun provideToDoDataBase(context: Application):ToDoDatabase =
    Room.databaseBuilder(context, ToDoDatabase::class.java, DATABASE_NAME).allowMainThreadQueries().build()

fun provideToDoDao(db: ToDoDatabase):ToDoDao = db.toDoDao()
