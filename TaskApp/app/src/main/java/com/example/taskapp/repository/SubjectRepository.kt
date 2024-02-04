package com.example.taskapp.repository

import androidx.lifecycle.LiveData
import com.example.taskapp.data.entities.Subject
import com.example.taskapp.data.dao.SubjectDao
import com.example.taskapp.data.entities.Task

class SubjectRepository(private val subjectDao: SubjectDao) {
    val readAllSubjects: LiveData<List<Subject>> = subjectDao.findAllSubjects()

    suspend fun addSubject(subject: Subject){
        subjectDao.addSubject(subject)
    }
}