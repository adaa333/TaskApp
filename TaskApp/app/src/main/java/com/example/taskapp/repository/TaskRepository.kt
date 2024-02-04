package com.example.taskapp.repository

import androidx.lifecycle.LiveData
import com.example.taskapp.data.entities.Task
import com.example.taskapp.data.dao.TaskDao

class TaskRepository(private val taskDao: TaskDao) {
    val readAllTasks: LiveData<List<Task>> = taskDao.findAllTasks()

    suspend fun addTask(task: Task){
        taskDao.addTask(task)
    }
}