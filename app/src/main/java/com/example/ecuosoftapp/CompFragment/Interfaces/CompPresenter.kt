package com.example.ecuosoftapp.CompFragment.Interactors

import com.example.ecuosoftapp.xml.Comprobante

interface CompPresenter {
    fun ShowProgressBarPresenter(mostrar: Boolean)
    fun ShowRecyclerViewPresenter(mostrar: Boolean)
    fun ShowdatosRecyclerViewPresenter(adetalleComp: ArrayList<Comprobante>)
    fun ShowErrorPresenter(mensaje: String)

}
