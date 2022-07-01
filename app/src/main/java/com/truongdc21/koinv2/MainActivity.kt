package com.truongdc21.koinv2

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.truongdc21.koinv2.base.BaseActivity
import com.truongdc21.koinv2.databinding.ActivityMainBinding
import com.truongdc21.koinv2.model.ToDo
import com.truongdc21.koinv2.test.Student
import com.truongdc21.koinv2.viewmodel.TodoViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var mNavController: NavController
    private lateinit var mAppBarConfiguration: AppBarConfiguration

    override fun initViews() {
       setupNavigationView()

    }

    override fun initData() {
        testKoin()
    }

    private fun setupNavigationView() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment
        mNavController = navHostFragment.navController
        setupActionBarWithNavController(mNavController)
        mAppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.toDoListFragment,
                R.id.addToDoFragment
            )
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp(mAppBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun testKoin() {
        val studen = get<Student>()
        studen.beSmart()
        val vmd by inject<TodoViewModel>()
        vmd.insertTodo(ToDo(0,"2"))
    }
}
