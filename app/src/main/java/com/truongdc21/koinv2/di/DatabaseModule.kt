package com.truongdc21.koinv2.di

import android.app.Application
import androidx.room.Room
import com.truongdc21.koinv2.db.ToDoDao
import com.truongdc21.koinv2.db.ToDoDatabase
import com.truongdc21.koinv2.utils.ConfigDb
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class DatabaseModule {

    @Single
    fun provideToDoDataBase(context: Application): ToDoDatabase =
        Room.databaseBuilder(context, ToDoDatabase::class.java, ConfigDb.DATABASE_NAME).allowMainThreadQueries().build()

    @Single
    fun provideToDoDao(db: ToDoDatabase): ToDoDao = db.toDoDao()

}