package com.example.ecuosoftapp.PedidosActivity.Interfaces

import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapter

interface PedidosDatosView {
    fun cargarDatos(visibilidad: Boolean, sFechaHora: String, adapter: SpinnerAdapter)
    fun obtenerDatos(visibilidad: Boolean)


}