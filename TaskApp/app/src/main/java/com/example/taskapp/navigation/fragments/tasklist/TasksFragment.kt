package com.example.taskapp.navigation.fragments.tasklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentTasksBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TasksFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tasks, container, false)
        val binding = FragmentTasksBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener{
            val bottomSheetAddTask = BottomSheetDialogFragment()
            bottomSheetAddTask.show(requireActivity().supportFragmentManager, bottomSheetAddTask.tag)
        }

        return view
    }

}