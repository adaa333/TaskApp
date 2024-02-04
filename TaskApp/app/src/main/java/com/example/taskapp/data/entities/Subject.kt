package com.example.taskapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskapp.data.entities.Task

@Entity (tableName = "Subjects")
data class Subject(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "subject_id")
    val id: Long,
    val name: String,
    val mail: String,
    val password: Int,
    val list: List<Task>
)