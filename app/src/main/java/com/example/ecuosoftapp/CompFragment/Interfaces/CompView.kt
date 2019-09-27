package com.example.ecuosoftapp.CompFragment.Interactors

import com.example.ecuosoftapp.xml.Comprobante

interface CompView {
    fun ShowProgressBar(mostrar: Boolean)
    fun ShowRecyclerView(mostrar: Boolean)
    fun ShowdatosRecyclerView(comprobantes: ArrayList<Comprobante>)
    fun ShowError(mensaje: String)
}