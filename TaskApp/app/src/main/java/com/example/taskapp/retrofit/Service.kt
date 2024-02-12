package com.example.taskapp.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface Service {
    //endpoints
    @GET("url")
    suspend fun getX(): Response<XItems>
}