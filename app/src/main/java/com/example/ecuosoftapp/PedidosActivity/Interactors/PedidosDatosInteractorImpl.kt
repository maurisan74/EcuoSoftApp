package com.example.ecuosoftapp.PedidosActivity.Interactors

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.R
import java.text.SimpleDateFormat
import java.util.*

class PedidosDatosInteractorImpl(var presenter: PedidosDatosPresenter) : PedidosDatosInteractor {

    override fun BuscarPrioridadesPT(context: Context) {
        ArrayAdapter.createFromResource(
            context,
            R.array.prioridad,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            presenter.CargarPrioridadPTPresenter(adapter)
        }
    }
    override fun CargarFechaHoraInteractor() {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:MM", Locale.getDefault())
        val date = Date()
        presenter.CargarFechaHoraActualPresenter(dateFormat.format(date))
    }
    override fun SolicitarMaestrosPTInteractor() {
        //mmm
    }
}