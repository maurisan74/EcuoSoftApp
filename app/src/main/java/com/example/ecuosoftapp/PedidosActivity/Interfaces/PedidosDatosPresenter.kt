package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.content.Context
import android.widget.ArrayAdapter

interface PedidosDatosPresenter {
    fun SolicitarFechaHoraActualPresenter()
    fun CargarFechaHoraActualPresenter(sFechaHora: String)

    fun SolicitarPrioridadPTPresenter(context: Context)
    fun CargarPrioridadPTPresenter(listaDePrioridades: ArrayAdapter<CharSequence>)
}