package com.example.taskapp.navigation.fragments.subjectlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskapp.R
import com.example.taskapp.data.viewmodel.SubjectViewModel
import com.example.taskapp.databinding.FragmentSubjectsBinding
import com.example.taskapp.recycler.SubjectAdapter

class SubjectsFragment : Fragment() {
    lateinit var binding: FragmentSubjectsBinding
    private lateinit var vmSubject: SubjectViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subjects, container, false)

        //recycler
        val recycler = binding.recyclerViewSubjects
        val adapter = SubjectAdapter()
        recycler.adapter=adapter
        recycler.layoutManager= LinearLayoutManager(requireContext())

        //viewmodel
        vmSubject= ViewModelProvider(this).get(SubjectViewModel::class.java)
        vmSubject.readAllSubjects.observe(viewLifecycleOwner, Observer { subject ->
            adapter.setData(subject)

        })

    }

}

