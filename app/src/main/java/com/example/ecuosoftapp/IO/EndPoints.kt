package com.example.ecuosoftapp.IO

import com.example.ecuosoftapp.CompFragment.Modelo.ResponseCompBody
import com.example.ecuosoftapp.CompFragment.Modelo.ResponseCompHead
import com.example.ecuosoftapp.PedidosActivity.ModeloPedidos.*
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET ("clientes")
    fun getClientes():Call<List<ResponseClientes>>

    @GET ("empleados")
    fun getEmpleados():Call<List<ResponseEmpleados>>

    @GET ("instalaciones")
    fun getInstalaciones():Call<List<ResponseInstalaciones>>

    @GET ("proyectos")
    fun getProyectos():Call<List<ResponseProyectos>>

    @GET ("tipostrabajos")
    fun getTiposTrabajos():Call<List<ResponseTiposTrabajos>>

    @GET ("equipos")
    fun getEquipos():Call<List<ResponseEquipos>>

    @GET ("comp_head")
    fun getCompHead():Call<List<ResponseCompHead>>

    @GET ("comp_body")
    fun getCompBody():Call<List<ResponseCompBody>>

}