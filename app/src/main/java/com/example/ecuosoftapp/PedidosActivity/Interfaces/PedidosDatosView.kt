package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.Models.TiposdeTrabajos
import com.example.ecuosoftapp.View.Clientes


interface PedidosDatosView {
    fun OcultarElementos()
    fun VisualizarElementos()

    fun CargarPrioridadPT(listaDePrioridades: ArrayAdapter<CharSequence>, sFechaHora: String)

    fun CargarPedidosTrabajo(arraySpinner: ArrayAdapter<Clientes>)


}