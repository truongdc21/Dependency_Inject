package com.truongdc21.koinv2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val toDoTitle: String
)