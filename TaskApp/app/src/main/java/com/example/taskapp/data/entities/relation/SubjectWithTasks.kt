package com.example.taskapp.data.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.taskapp.data.entities.Subject
import com.example.taskapp.data.entities.Task

data class SubjectWithTasks (
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subject_id",
        entityColumn = "subject_id"
    )
    val tasks: List<Task> = emptyList()
)