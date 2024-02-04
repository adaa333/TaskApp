package com.example.taskapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskapp.data.entities.Subject
import com.example.taskapp.data.dao.SubjectDao
import com.example.taskapp.data.entities.Task
import com.example.taskapp.data.dao.TaskDao

@Database(entities = [Subject::class],[Task::class], version=1, exportSchema = true )
abstract class TaskDataBase : RoomDatabase(){
    abstract fun subjectDao(): SubjectDao

    companion object{
        @Volatile//?
        private var INSTANCE: TaskDataBase? = null

        fun getDatabase(context: Context): TaskDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){ //returning the same instance of the DB para optimizar
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "task_database"
                ).build()
                INSTANCE =instance
                return instance
            }
        }
    }

    abstract fun taskDao(): TaskDao

}