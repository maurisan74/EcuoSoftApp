package com.example.ecuosoftapp.PedidosActivity.View

import com.example.ecuosoftapp.PedidosActivity.PojosRetrofit.ResponseClientes
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET ("clientes")
    fun getClientes():Call<List<ResponseClientes>>
}