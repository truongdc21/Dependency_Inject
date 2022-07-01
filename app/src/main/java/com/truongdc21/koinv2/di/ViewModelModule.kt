package com.truongdc21.koinv2.di

import com.truongdc21.koinv2.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val ViewModelModule: Module = module {
    viewModel { TodoViewModel (get())}
}
