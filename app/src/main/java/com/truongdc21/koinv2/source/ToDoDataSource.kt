package com.truongdc21.koinv2.source

import com.truongdc21.koinv2.model.ToDo

interface ToDoDataSource{

    /**
     * This is code for local
     */
    interface Local {

        suspend fun insertTodo(todo : ToDo)

        suspend fun deleteTodo (todo: ToDo)

        fun getAllTodo() :  kotlinx.coroutines.flow.Flow<List<ToDo>>
    }

    /**
     * This is code for remote
     */
    interface Remote {

    }
}