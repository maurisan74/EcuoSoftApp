package com.example.ecuosoftapp.CompFragment.Interactors

import com.example.ecuosoftapp.CompFragment.Modelo.ResponseCompHead
import com.example.ecuosoftapp.CompFragment.View.AdapterLanding

interface CompView {
    fun ShowProgressBar(mostrar: Boolean)
    fun ShowRecyclerView(mostrar: Boolean)
    fun LoadDatosRecyclerView(adapter2: ArrayList<ResponseCompHead>)
    fun ShowError(mensaje: String)
    fun ListaEmpleados(listEmple: ArrayList <String>)
    fun ListaEmpresas(listEmp: ArrayList <String>)


}