package com.truongdc21.koinv2.di

import com.truongdc21.koinv2.repository.ToDoRepositoryIplm
import com.truongdc21.koinv2.source.ToDoDataSource
import com.truongdc21.koinv2.source.local.ToDoLocalSource
import com.truongdc21.koinv2.source.remote.ToDoRemoteSource
import org.koin.dsl.module

val repositoryModule = module {
    factory { providerTodoRepository(ToDoLocalSource(get()) ,ToDoRemoteSource()) }
}

fun providerTodoRepository(
    local : ToDoDataSource.Local,
    remote : ToDoDataSource.Remote
): ToDoRepositoryIplm{
    return ToDoRepositoryIplm(local , remote)
}
