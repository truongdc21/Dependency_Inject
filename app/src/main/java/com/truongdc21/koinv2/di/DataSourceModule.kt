package com.truongdc21.koinv2.di

import com.truongdc21.koinv2.db.ToDoDao
import com.truongdc21.koinv2.source.ToDoDataSource
import com.truongdc21.koinv2.source.local.ToDoLocalSource
import com.truongdc21.koinv2.source.remote.ToDoRemoteSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideToDoDataSourceLocal(dao: ToDoDao): ToDoDataSource.Local{
        return ToDoLocalSource(dao)
    }

    @Singleton
    @Provides
    fun provideToDoDataSourceRemote(): ToDoDataSource.Remote{
        return ToDoRemoteSource()
    }
}
