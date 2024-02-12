package com.example.taskapp.navigation.fragments.tasklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskapp.R
import com.example.taskapp.data.viewmodel.SubjectViewModel
import com.example.taskapp.data.viewmodel.TaskViewModel
import com.example.taskapp.databinding.FragmentTasksBinding
import com.example.taskapp.recycler.SubjectAdapter
import com.example.taskapp.recycler.TaskAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TasksFragment : Fragment() {

    private lateinit var vmTask: TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tasks, container, false)
        val binding = FragmentTasksBinding.inflate(inflater, container, false)

        //recycler
        val recycler = binding.recyclerViewTasks
        val adapter = TaskAdapter()
        recycler.adapter=adapter
        recycler.layoutManager= LinearLayoutManager(requireContext())

        //viewmodel
        vmTask= ViewModelProvider(this).get(TaskViewModel::class.java)
        vmTask.readAllTasks.observe(viewLifecycleOwner, Observer { task ->
            adapter.setData(task)
        })

        binding.floatingActionButton.setOnClickListener{
            val bottomSheetAddTask = BottomSheetDialogFragment()
            bottomSheetAddTask.show(requireActivity().supportFragmentManager, bottomSheetAddTask.tag)
        }

        return view
    }

}