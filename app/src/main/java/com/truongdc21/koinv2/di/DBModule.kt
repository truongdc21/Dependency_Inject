package com.truongdc21.koinv2.di

import android.content.Context
import androidx.room.Room
import com.truongdc21.koinv2.db.ToDoDao
import com.truongdc21.koinv2.db.ToDoDatabase
import com.truongdc21.koinv2.utils.ConfigDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideToDoDataBase(@ApplicationContext context: Context): ToDoDatabase =
        Room.databaseBuilder(context, ToDoDatabase::class.java, ConfigDb.DATABASE_NAME).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideToDoDao(db: ToDoDatabase): ToDoDao = db.toDoDao()

}