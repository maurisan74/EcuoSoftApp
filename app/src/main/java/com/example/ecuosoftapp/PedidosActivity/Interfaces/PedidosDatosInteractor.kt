package com.example.ecuosoftapp.PedidosActivity.Interfaces

import android.content.Context

interface PedidosDatosInteractor {
    fun CargarFechaHoraInteractor()
    fun BuscarPrioridadesPT(context: Context)
    fun SolicitarPedidoTrabajoInteractor(context: Context)
    fun ShowElemns()

}