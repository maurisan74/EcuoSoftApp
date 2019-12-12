package com.example.ecuosoftapp.PedidosActivity.View

import retrofit2.http.GET

interface EndPoints {

    @GET()
    fun getList()
}