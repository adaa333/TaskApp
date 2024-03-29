package com.example.taskapp.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taskapp.data.database.TaskDataBase
import com.example.taskapp.data.entities.Task
import com.example.taskapp.data.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TaskViewModel (application: Application): AndroidViewModel(application){
    val readAllTasks : LiveData<List<Task>>
    private val repository: TaskRepository

    init{ //?
        val taskDao = TaskDataBase.getDatabase(application).taskDao()
        repository= TaskRepository(taskDao)
        readAllTasks= repository.readAllTasks
    }

    fun addTask(task: Task){
        viewModelScope.launch (Dispatchers.IO){ //?
            repository.addTask(task)
        }
    }
}