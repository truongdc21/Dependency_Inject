package com.truongdc21.koinv2.source.local

import com.truongdc21.koinv2.db.ToDoDao
import com.truongdc21.koinv2.model.ToDo
import com.truongdc21.koinv2.source.ToDoDataSource
import java.util.concurrent.Flow

class ToDoLocalSource (
    private val toDoDao: ToDoDao
): ToDoDataSource.Local {

    override suspend fun insertTodo(todo: ToDo) {
        toDoDao.insertToDo(todo)
    }

    override suspend fun deleteTodo(todo: ToDo) {
        toDoDao.deleteToDo(todo)
    }

    override fun getAllTodo(): kotlinx.coroutines.flow.Flow<List<ToDo>> {
        return toDoDao.getAllToDos()
    }

}