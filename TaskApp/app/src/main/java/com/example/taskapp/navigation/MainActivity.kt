package com.example.taskapp.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import com.example.taskapp.R
import com.example.taskapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LifecycleOwner {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Navigation
        binding.bottomNavigationView.setOnItemSelectedListener
        //ViewModel

    }
}