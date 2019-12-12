package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.SearchFragment.Clientes

interface PedidosDatosPresenter {
    fun OcultarElementosPresenter()
    fun VisualizarElementosPresenter()

    fun SolicitarPrioridadPTPresenter(context: Context)
    fun CargarPrioridadPTPresenter(listaDePrioridades: ArrayAdapter<CharSequence>, sFechaHora: String)

    fun SolicitarPedidoTrabajoPresenter(context: Context)
    fun CargarPedidoTrabajoPresenter(arraySpinner: ArrayAdapter<Clientes>)
}