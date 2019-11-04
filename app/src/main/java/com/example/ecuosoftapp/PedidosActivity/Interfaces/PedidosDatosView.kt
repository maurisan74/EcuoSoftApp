package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.widget.ArrayAdapter

interface PedidosDatosView {
    fun ShowProgressBar(mostrar: Boolean)
    fun ShowNestedScrollView(mostrar: Boolean)

    fun CargarFechaHoraActual(sFechaHora: String)

    fun CargarPrioridadPT(listaDePrioridades: ArrayAdapter<CharSequence>)

    fun CargarPedidosTrabajo(listaPedidos: ArrayAdapter<CharSequence>)
}