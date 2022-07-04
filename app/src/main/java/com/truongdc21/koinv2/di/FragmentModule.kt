package com.truongdc21.koinv2.di

import com.truongdc21.koinv2.fragment.AddToDoFragment
import com.truongdc21.koinv2.fragment.ToDoListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesAddToDoFragment(): AddToDoFragment

    @ContributesAndroidInjector
    abstract fun contributesToDoListFragment(): ToDoListFragment

}