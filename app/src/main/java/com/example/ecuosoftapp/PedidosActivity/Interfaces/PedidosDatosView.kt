package com.example.ecuosoftapp.PedidosActivity.Interfaces

import com.example.ecuosoftapp.PedidosActivity.IO.SpinnerAdapterClientes
import com.example.ecuosoftapp.PedidosActivity.IO.SpinnerAdapterEmpleados
import com.example.ecuosoftapp.PedidosActivity.IO.SpinnerAdapterTrabajos

interface PedidosDatosView {
//    fun cargarDatos(visibilidad: Boolean, sFechaHora: String, adapterClientes: SpinnerAdapterClientes, adapterTrabajos: SpinnerAdapterTrabajos, adapterEmpleados: SpinnerAdapterEmpleados)
    fun cargarDatos(visibilidad: Boolean, sFechaHora: String, adapterTrabajos: SpinnerAdapterTrabajos, adapterEmpleados: SpinnerAdapterEmpleados)
    fun obtenerDatos(visibilidad: Boolean)


}