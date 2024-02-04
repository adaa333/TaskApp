package com.example.taskapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taskapp.data.database.TaskDataBase
import com.example.taskapp.data.entities.Subject
import com.example.taskapp.repository.SubjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// proporciona datos a la IU y sobrevive a cambios de configuracion- centro de comunicacion entre el Repository y la IU
class SubjectViewModel(application: Application) : AndroidViewModel(application){
    private val readAllSubjects : LiveData<List<Subject>>
    private val repository: SubjectRepository

    init{ //?
        val subjectDao = TaskDataBase.getDatabase(application).subjectDao()
        repository= SubjectRepository(subjectDao)
        readAllSubjects= repository.readAllSubjects
    }

    fun addSubject(subject: Subject){
        viewModelScope.launch (Dispatchers.IO){ //?
            repository.addSubject(subject)
        }
    }
}
