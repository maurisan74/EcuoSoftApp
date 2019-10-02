package com.example.ecuosoftapp.DetalleFragment.Interfaces

import com.example.ecuosoftapp.DetalleFragment.xml.DetalleComp

interface DetalleView {
    fun ShowProgressBar(mostrar: Boolean)
    fun ShowRecyclerView(mostrar: Boolean)
    fun ShowdatosRecyclerView(adetalleComp: ArrayList<DetalleComp>)
    fun ShowError(mensaje: String)
}