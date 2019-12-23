package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.content.Context
import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapter

interface PedidosDatosPresenter {
    fun obtenerDatosPresenter(visibilidad: Boolean)

    fun interacturServerInteractor(context: Context)
    fun cargarDatosPresenter(visibilidad: Boolean, sFechaHora: String, adapter: SpinnerAdapter)
}