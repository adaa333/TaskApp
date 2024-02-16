package com.example.taskapp.navigation.fragments.addtask

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.taskapp.R
import com.example.taskapp.data.entities.Task
import com.example.taskapp.databinding.FragmentTasksBinding
import com.example.taskapp.databinding.TaskItemBinding
import com.example.taskapp.data.viewmodel.TaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Date

class AddTaskFragment : BottomSheetDialogFragment() {

    //private val args: AddTaskFragmentArgs by navArgs<AddTaskFragmentArgs>()

    private lateinit var binding: TaskItemBinding
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var dueDate: Date
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)

        taskViewModel= ViewModelProvider(this)[TaskViewModel::class.java]
        val addTaskButton: Button = view.findViewById(R.id.addTask)
        val pickDateButton: Button = view.findViewById(R.id.datePicker)

        pickDateButton.setOnClickListener(){

        }

        addTaskButton.setOnClickListener(){
           //insertTaskToDatabase()
        }
        return view
    }

    private fun insertTaskToDatabase(dueDate: Date, subjectId: Long) {
        val title = binding.textViewTitle.text.toString()
        val description =binding.textViewTitle.text.toString()

        if(inputCheck(title,description) ){
            val task= Task(subjectId, title, description, dueDate)
            taskViewModel.addTask(task)
        }

    }

    private fun insertTaskToDatabase(subjectId: Long) {
        val title = binding.textViewTitle.text.toString()
        val description =binding.textViewTitle.text.toString()

        if( inputCheck(title,description) ){
            val task= Task(subjectId, title, description, dueDate)
            taskViewModel.addTask(task)
        }

    }

    private fun inputCheck(title: String, description: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }

}