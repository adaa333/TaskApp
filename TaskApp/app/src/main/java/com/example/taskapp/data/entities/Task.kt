package com.example.taskapp.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Date

@Entity (tableName = "Tasks")
@Parcelize
data class Task (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "task_id")
    val id: Long,
    val titulo: String,
    val descripcion: String,
    val fechaLimite: Date

): Parcelable