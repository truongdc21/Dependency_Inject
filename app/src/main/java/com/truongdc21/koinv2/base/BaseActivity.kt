package com.truongdc21.koinv2.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> (
    val inflate : (LayoutInflater) -> VB
    ): AppCompatActivity() {

    protected val binding : VB by lazy { inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        initData()
    }

    abstract fun initViews()

    abstract fun initData()
}
