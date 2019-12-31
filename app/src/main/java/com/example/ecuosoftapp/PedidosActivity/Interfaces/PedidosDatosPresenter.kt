package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.content.Context
import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapterClientes
import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapterTrabajos

interface PedidosDatosPresenter {
    fun obtenerDatosPresenter(visibilidad: Boolean)

    fun interacturServerInteractor(context: Context)
    fun cargarDatosPresenter(visibilidad: Boolean, sFechaHora: String, adapterClientes: SpinnerAdapterClientes, adapterTrabajos: SpinnerAdapterTrabajos)
}