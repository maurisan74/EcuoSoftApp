package com.example.ecuosoftapp.DetalleFragment.Interfaces

import com.example.ecuosoftapp.xml.DetalleComp

interface DetalleView {
    fun ShowProgressBar(mostrar: Boolean)
    fun ShowdatosRecyclerView(adetalleComp: ArrayList<DetalleComp>)
    fun ShowError(mensaje: String)
}