package com.example.ecuosoftapp.DetalleFragment.Interfaces

import android.content.Context
import com.example.ecuosoftapp.xml.DetalleComp

interface DetallePresenter {
    fun ShowProgressBarPresenter(mostrar: Boolean)
    fun ShowdatosRecyclerViewPresenter(adetalleComp: ArrayList<DetalleComp>)
    fun ShowErrorPresenter(mensaje: String)
    fun BuscarDatosPresenter(context: Context)

}