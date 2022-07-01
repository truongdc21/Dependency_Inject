package com.truongdc21.koinv2.fragment

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.truongdc21.koinv2.R
import com.truongdc21.koinv2.adapter.TodoAdapter
import com.truongdc21.koinv2.base.BaseFragment
import com.truongdc21.koinv2.databinding.FragmentToDoListBinding
import com.truongdc21.koinv2.model.ToDo
import com.truongdc21.koinv2.utils.showToast
import com.truongdc21.koinv2.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToDoListFragment:
    BaseFragment<FragmentToDoListBinding> (FragmentToDoListBinding::inflate){

    private lateinit var todoAdapter  : TodoAdapter

    private val mViewModel : TodoViewModel by viewModel()

    override fun initView() {
        setUpRecyclerview()
        clickFabTask()
    }

    override fun initData() {
    }

    private fun setUpRecyclerview() {
        todoAdapter = TodoAdapter(deleteTodo = { data ->
            mViewModel.deleteToDo(data)
            this@ToDoListFragment.context?.showToast("Delete Successsfully..")
        })

        binding.rvTodoList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = todoAdapter
        }

        mViewModel.allToDos.observe(this.viewLifecycleOwner , Observer {listTodo ->
            updateUi(listTodo)
            todoAdapter.mTodo = listTodo
        })
    }

    private fun clickFabTask() {
        binding.fabAddTask.setOnClickListener {
            this@ToDoListFragment.findNavController().navigate(
                R.id.action_toDoListFragment_to_addToDoFragment
            )

        }
    }

    private fun updateUi(list: List<ToDo>) {
        if (list.isNotEmpty()) {
            binding.rvTodoList.visibility = View.VISIBLE
            binding.cardView.visibility = View.GONE
        } else {
            binding.rvTodoList.visibility = View.GONE
            binding.cardView.visibility = View.VISIBLE
        }
    }
}
