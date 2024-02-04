package com.example.taskapp.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import com.example.taskapp.R

class MainActivity : AppCompatActivity(), LifecycleOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ViewModel

    }
}