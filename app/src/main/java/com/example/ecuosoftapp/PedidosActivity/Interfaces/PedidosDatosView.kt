package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.widget.ArrayAdapter

interface PedidosDatosView {
    fun ShowProgressBar(mostrar: Boolean)

    fun SolicitarFechaHoraActual()
    fun CargarFechaHoraActual(sFechaHora: String)

    fun SolicitarPrioridadPT()
    fun CargarPrioridadPT(listaDePrioridades: ArrayAdapter<CharSequence>)

    fun SolicitarMaestrosPT()

}