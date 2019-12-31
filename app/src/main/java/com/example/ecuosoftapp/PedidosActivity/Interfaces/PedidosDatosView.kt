package com.example.ecuosoftapp.PedidosActivity.Interfaces

import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapterClientes
import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapterTrabajos

interface PedidosDatosView {
    fun cargarDatos(visibilidad: Boolean, sFechaHora: String, adapterClientes: SpinnerAdapterClientes, adapterTrabajos: SpinnerAdapterTrabajos)
    fun obtenerDatos(visibilidad: Boolean)


}