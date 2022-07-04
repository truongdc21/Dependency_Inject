package com.truongdc21.koinv2.repository

import com.truongdc21.koinv2.base.BaseRepository
import com.truongdc21.koinv2.model.ToDo
import com.truongdc21.koinv2.source.ToDoDataSource
import javax.inject.Inject

class ToDoRepositoryIplm @Inject constructor (
    private val todoLocal: ToDoDataSource.Local,
    private val todoRemote: ToDoDataSource.Remote
    ): BaseRepository() {

    suspend fun insertToDo(toDo: ToDo) = withContextResult {
        todoLocal.insertTodo(toDo)
    }

    suspend fun deleteToDo(toDo: ToDo) = withContextResult {
        todoLocal.deleteTodo(toDo)
    }

    fun getAllToDo() = todoLocal.getAllTodo()
}
