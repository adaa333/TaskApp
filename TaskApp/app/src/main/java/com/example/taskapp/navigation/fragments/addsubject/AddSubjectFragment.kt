package com.example.taskapp.navigation.fragments.addsubject

import android.graphics.Paint.Style
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.taskapp.R
import com.example.taskapp.data.entities.Subject
import com.example.taskapp.data.entities.Task
import com.example.taskapp.databinding.FragmentAddSubjectBinding
import com.example.taskapp.databinding.SubjectItemBinding
import com.example.taskapp.data.viewmodel.SubjectViewModel
import com.example.taskapp.data.viewmodel.TaskViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Date

class AddSubjectFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddSubjectBinding
    private lateinit var subjectViewModel: SubjectViewModel
    private val chosenTheme: String?
        get() {
            return chosenTheme
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddSubjectBinding.inflate(inflater, container, false)
        val view= binding.root
        subjectViewModel= ViewModelProvider(this)[SubjectViewModel::class.java]
        val saveSubject: Button = binding.saveSubject
        val deleteSubject: Button = binding.deleteSubject

        val chosenTheme: String? = when (binding.asignarTema.checkedRadioButtonId) {
            binding.blueTheme.id -> "ThemeBlue"
            binding.greenTheme.id -> "ThemeGreen"
            binding.pinkTheme.id -> "ThemePink"
            binding.orangeTheme.id -> "ThemeOrange"
            binding.purpleTheme.id -> "ThemePurple"
            binding.yellowTheme.id -> "ThemeYellow"
            binding.redTheme.id -> "ThemeRed"
            else -> null
        }

        binding.asignarTema.setOnCheckedChangeListener{ group, checkedId ->

        }

        saveSubject.setOnClickListener(){
            insertSubjectToDatabase()
        }

        deleteSubject.setOnClickListener(){

        }
        return view
    }

    private fun insertSubjectToDatabase() {
        val name = binding.textViewSubjectName.text.toString()
        val theme = chosenTheme.toString()

        if( inputCheck(name,theme) ){
            val subject= Subject(0L, name, theme, ArrayList())
            subjectViewModel.addSubject(subject)
            Toast.makeText(requireContext(), "Subject Added!", Toast.LENGTH_LONG)
        }else{
            Toast.makeText(requireContext(), "Fill In All Fields Before Saving", Toast.LENGTH_LONG)

        }

    }

    private fun inputCheck(title: String, theme: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(theme))
    }


}