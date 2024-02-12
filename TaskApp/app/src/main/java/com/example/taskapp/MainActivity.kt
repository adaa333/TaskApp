package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.taskapp.R
import com.example.taskapp.databinding.ActivityMainBinding
import com.example.taskapp.retrofit.RetrofitInstance
import com.example.taskapp.retrofit.Service
import com.example.taskapp.retrofit.XItems
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import retrofit2.Response

class MainActivity : AppCompatActivity(), LifecycleOwner {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Navigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment //?
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_item -> {
                    navController.navigate(R.id.subjectsFragment)
                    true
                }

                R.id.add_item -> {
                    val bottomSheetAddTask = BottomSheetDialogFragment()
                    bottomSheetAddTask.show(supportFragmentManager, bottomSheetAddTask.tag)
                    true
                }

                R.id.calendar_item -> {
                    navController.navigate(R.id.calendarFragment)
                    true
                }
                else -> false
            }
        }

        //Retrofit
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(Service::class.java)

        val responseLiveData : LiveData<Response<XItems>> =
            liveData {
                val response = retrofitService.getX()

                //+ peticiones + responses

                emit(response)
            }

        //ViewModel

    }
}