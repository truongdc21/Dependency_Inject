package com.truongdc21.koinv2

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.truongdc21.koinv2.base.BaseActivity
import com.truongdc21.koinv2.databinding.ActivityMainBinding
import dagger.Module

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var mNavController: NavController
    private lateinit var mAppBarConfiguration: AppBarConfiguration

    override fun initViews() {
       setupNavigationView()
    }

    override fun initData() {
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
}
