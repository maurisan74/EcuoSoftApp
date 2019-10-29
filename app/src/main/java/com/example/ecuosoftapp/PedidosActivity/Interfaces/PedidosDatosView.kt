package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.widget.ArrayAdapter

interface PedidosDatosView {
    fun SolicitarFechaHoraActual()
    fun CargarFechaHoraActual(sFechaHora: String)

    fun SolicitarPrioridadPT()
    fun CargarPrioridadPT(listaDePrioridades: ArrayAdapter<CharSequence>)
}