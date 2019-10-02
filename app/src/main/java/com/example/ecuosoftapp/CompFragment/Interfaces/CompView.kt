package com.example.ecuosoftapp.CompFragment.Interactors

import android.content.Context
import com.example.ecuosoftapp.CompFragment.xml.Comprobante

interface CompView {
    fun ShowProgressBar(mostrar: Boolean)
    fun ShowRecyclerView(mostrar: Boolean)
    fun LoadDatosRecyclerView(comprobantes: ArrayList<Comprobante>)
    fun ShowError(mensaje: String)
    fun ListaEmpleados(listEmple: ArrayList <String>)
    fun ListaEmpresas(listEmp: ArrayList <String>)


}