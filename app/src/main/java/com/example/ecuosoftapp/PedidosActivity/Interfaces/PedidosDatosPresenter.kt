package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.xml.TiposdeTrabajos

interface PedidosDatosPresenter {
    fun OcultarElementosPresenter()
    fun VisualizarElementosPresenter()

    fun SolicitarFechaHoraActualPresenter()
    fun CargarFechaHoraActualPresenter(sFechaHora: String)

    fun SolicitarPrioridadPTPresenter(context: Context)
    fun CargarPrioridadPTPresenter(listaDePrioridades: ArrayAdapter<CharSequence>)

    fun SolicitarPedidoTrabajoPresenter(context: Context)
    fun CargarPedidoTrabajoPresenter(arraySpinner: ArrayAdapter<String>)
}