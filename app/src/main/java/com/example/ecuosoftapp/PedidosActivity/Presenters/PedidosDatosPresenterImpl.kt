package com.example.ecuosoftapp.PedidosActivity.Presenters

import android.content.Context
import com.example.ecuosoftapp.PedidosActivity.Interactors.PedidosDatosInteractorImpl
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.View.PedidosDatosFragment
import com.example.ecuosoftapp.PedidosActivity.ModeloPedidos.SpinnerAdapterEmpleados
import com.example.ecuosoftapp.PedidosActivity.ModeloPedidos.SpinnerAdapterTrabajos

class PedidosDatosPresenterImpl(var view: PedidosDatosFragment) : PedidosDatosPresenter {

    private val interactor: PedidosDatosInteractor

    init { interactor= PedidosDatosInteractorImpl(this) }

    override fun interacturServerInteractor(context: Context) {interactor.interacturServerInteractor(context)}
//    override fun cargarDatosPresenter(visibilidad: Boolean, sFechaHora: String, adapterClientes: SpinnerAdapterClientes, adapterTrabajos: SpinnerAdapterTrabajos, adapterEmpleados: SpinnerAdapterEmpleados) {view.cargarDatos(visibilidad, sFechaHora, adapterClientes, adapterTrabajos, adapterEmpleados)}

    override fun cargarDatosPresenter(visibilidad: Boolean, sFechaHora: String,  adapterTrabajos: SpinnerAdapterTrabajos, adapterEmpleados: SpinnerAdapterEmpleados) {view.cargarDatos(visibilidad, sFechaHora, adapterTrabajos, adapterEmpleados)}

   override fun obtenerDatosPresenter(visibilidad: Boolean) {view.obtenerDatos(visibilidad)}

}
