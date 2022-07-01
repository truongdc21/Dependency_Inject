package com.truongdc21.koinv2.db

import androidx.room.*
import com.truongdc21.koinv2.model.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

    @Query("SELECT * FROM todo ORDER BY toDoTitle ASC ")
    fun getAllToDos(): Flow<List<ToDo>>

}