package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.widget.ArrayAdapter
import com.example.ecuosoftapp.SearchFragment.Clientes


interface PedidosDatosView {
    fun OcultarElementos()
    fun VisualizarElementos( sFechaHora: String)

    fun CargarPedidosTrabajo(arraySpinner: ArrayAdapter<Clientes>)


}