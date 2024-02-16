package com.example.taskapp.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query
import com.example.taskapp.data.entities.Subject
import com.example.taskapp.data.dao.SubjectDao
import com.example.taskapp.data.entities.Task
import com.example.taskapp.data.entities.relation.SubjectWithTasks

class SubjectRepository(private val subjectDao: SubjectDao) {
    val readAllSubjects: LiveData<List<Subject>> = subjectDao.findAllSubjects()

    suspend fun addSubject(subject: Subject){
        subjectDao.addSubject(subject)
    }
}