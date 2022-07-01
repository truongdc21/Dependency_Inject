package com.truongdc21.koinv2.di

import com.truongdc21.koinv2.db.ToDoDao
import com.truongdc21.koinv2.repository.ToDoRepositoryIplm
import com.truongdc21.koinv2.source.ToDoDataSource
import com.truongdc21.koinv2.source.local.ToDoLocalSource
import com.truongdc21.koinv2.source.remote.ToDoRemoteSource
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class RepositoryModule {

    @Factory
    fun providerTodoRepository(
        local : ToDoDataSource.Local,
        remote : ToDoDataSource.Remote
    ): ToDoRepositoryIplm {
        return ToDoRepositoryIplm(local , remote)
    }

    @Single
    fun provideToDoDataSourceLocal(dao: ToDoDao): ToDoDataSource.Local{
        return ToDoLocalSource(dao)
    }

    @Single
    fun provideToDoDataSourceRemote(): ToDoDataSource.Remote{
        return ToDoRemoteSource()
    }
}
