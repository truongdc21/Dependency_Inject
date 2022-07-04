package com.truongdc21.koinv2.di

import android.content.Context
import androidx.room.Room
import com.truongdc21.koinv2.db.ToDoDao
import com.truongdc21.koinv2.db.ToDoDatabase
import com.truongdc21.koinv2.utils.ConfigDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule(
  private val context: Context
) {

    @Singleton
    @Provides
    fun provideToDoDataBase(): ToDoDatabase =
        Room.databaseBuilder(context, ToDoDatabase::class.java, ConfigDb.DATABASE_NAME).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideToDoDao(db: ToDoDatabase): ToDoDao = db.toDoDao()
}
