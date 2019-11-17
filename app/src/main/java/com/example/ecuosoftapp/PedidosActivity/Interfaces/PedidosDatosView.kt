package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.widget.ArrayAdapter

interface PedidosDatosView {
    fun OcultarElementos()
    fun VisualizarElementos()

    fun CargarFechaHoraActual(sFechaHora: String)

    fun CargarPrioridadPT(listaDePrioridades: ArrayAdapter<CharSequence>)

    fun CargarPedidosTrabajo(arraySpinner: ArrayAdapter<String>)
}