package com.truongdc21.koinv2.viewmodel

import android.util.Log
import androidx.lifecycle.asLiveData
import com.truongdc21.koinv2.base.BaseViewModel
import com.truongdc21.koinv2.model.ToDo
import com.truongdc21.koinv2.repository.ToDoRepositoryIplm
import javax.inject.Inject

class TodoViewModel @Inject constructor(
   private val toDoRepositoryIplm: ToDoRepositoryIplm
) : BaseViewModel() {

    fun insertTodo(toDo: ToDo) {
        launchTaskSync(
            onRequest = {
                toDoRepositoryIplm.insertToDo(toDo)
            }, onSuccess = {
                Log.d("x2" , "Insert Success")
            }
        )
        Log.d("x2", "Insert Success")
    }

    fun deleteToDo(toDo: ToDo) {
        launchTaskSync(
            onRequest = {
                toDoRepositoryIplm.deleteToDo(toDo)
            }, onSuccess = {
                Log.d("x2" , "Delete Success")
            }
        )
    }
     val allToDos = toDoRepositoryIplm.getAllToDo().asLiveData()
}
