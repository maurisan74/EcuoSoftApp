package com.example.ecuosoftapp.PedidosActivity.IO


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PedidosApiAdapter {

    const val BASE_URL ="http://192.168.0.101:3000/api/"
    //"http://10.0.2.2:3000/api/"


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val request = retrofit.create(EndPoints::class.java)
}