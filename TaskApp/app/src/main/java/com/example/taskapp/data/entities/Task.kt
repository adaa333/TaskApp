package com.example.taskapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity (tableName = "Tasks")
data class Task (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "task_id")
    val id: Long,
    @ColumnInfo (name="subject_id")
    val subjectId: Long,
    val titulo: String,
    val descripcion: String,
    val fechaLimite: Date

)