package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.content.Context
import com.example.ecuosoftapp.PedidosActivity.ModeloPedidos.SpinnerAdapterEmpleados
import com.example.ecuosoftapp.PedidosActivity.ModeloPedidos.SpinnerAdapterTrabajos

interface PedidosDatosPresenter {
    fun obtenerDatosPresenter(visibilidad: Boolean)

    fun interacturServerInteractor(context: Context)
//    fun cargarDatosPresenter(visibilidad: Boolean, sFechaHora: String, adapterClientes: SpinnerAdapterClientes, adapterTrabajos: SpinnerAdapterTrabajos, adapterEmpleados: SpinnerAdapterEmpleados)
    fun cargarDatosPresenter(visibilidad: Boolean, sFechaHora: String,  adapterTrabajos: SpinnerAdapterTrabajos, adapterEmpleados: SpinnerAdapterEmpleados)

}