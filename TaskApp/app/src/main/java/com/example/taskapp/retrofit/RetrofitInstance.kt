package com.example.taskapp.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        val BASE_URL="url full del API"

                fun getRetrofitInstance(): Retrofit {
                    return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                        GsonConverterFactory.create(GsonBuilder().create())).build()
                }
    }



}