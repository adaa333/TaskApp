package com.example.taskapp.data.database

import android.content.Context
import android.os.Bundle
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.taskapp.data.dao.SubjectDao
import com.example.taskapp.data.dao.TaskDao
import com.example.taskapp.data.entities.Subject
import com.example.taskapp.data.entities.Task
import com.example.taskapp.util.Converters


@Database(entities = [Subject::class],[Task::class], version=1, exportSchema = true )
@TypeConverters (Converters::class)
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

    //val db = Room.databaseBuilder(applicationContext, TaskDataBase::class.java, "TaskDataBase").build()

}