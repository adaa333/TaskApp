package com.example.taskapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskapp.data.entities.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)
    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateTask(task: Task)
    @Delete
    fun removeTask(task: Task)

    @Query("SELECT * FROM Tasks WHERE task_id= :id")
    fun findTaskById(id: Int)
    @Query("SELECT * FROM Tasks ORDER BY task_id ASC")
    fun findAllTasks(): LiveData<List<Task>>
}