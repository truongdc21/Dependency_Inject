package com.truongdc21.koinv2.fragment

import android.content.Context
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.truongdc21.koinv2.R
import com.truongdc21.koinv2.base.BaseFragment
import com.truongdc21.koinv2.databinding.FragmentAddToDoBinding
import com.truongdc21.koinv2.model.ToDo
import com.truongdc21.koinv2.utils.showToast
import com.truongdc21.koinv2.viewmodel.TodoViewModel
import dagger.Module
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AddToDoFragment : BaseFragment<FragmentAddToDoBinding>(FragmentAddToDoBinding::inflate) {

    @Inject lateinit var mViewModel : TodoViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
    override fun initView() {
        binding.btnAddTask.setOnClickListener { mView ->
            saveNote(mView)
        }

        binding.btnCancel.setOnClickListener {
            binding.etTodoName.text.clear()
            this@AddToDoFragment.findNavController().navigate(
                R.id.action_addToDoFragment_to_toDoListFragment
            )
        }
    }

    override fun initData() {

    }

    private fun saveNote(view: View) {
        val todoName = binding.etTodoName.text.toString()

        if (todoName.isNotEmpty()) {
            val todo = ToDo(0, todoName)

            mViewModel.insertTodo(todo)

            this@AddToDoFragment.context?.showToast("ToDo Saved Successfully")

            view.findNavController().navigate(
                R.id.action_addToDoFragment_to_toDoListFragment
            )
        } else {
            this@AddToDoFragment.context?.showToast("Todo title can not be empty")
        }
    }
}
