package com.example.taskapp.retrofit

import com.google.gson.annotations.SerializedName

data class XItem(

    /*
    * estructurar los datos según como estén hechos los gson de la api que vaya a usar
    *
    * */
    @SerializedName("id")
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("id")
    val title: String,
)
