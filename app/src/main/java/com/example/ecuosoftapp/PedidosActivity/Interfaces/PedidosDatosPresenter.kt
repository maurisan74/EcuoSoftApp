package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.SearchFragment.Clientes

interface PedidosDatosPresenter {
    fun OcultarElementosPresenter()
    fun VisualizarElementosPresenter( sFechaHora: String)

    fun SolicitarPrioridadPTPresenter(context: Context)


    fun SolicitarPedidoTrabajoPresenter(context: Context)
    fun CargarPedidoTrabajoPresenter(arraySpinner: ArrayAdapter<Clientes>)
}