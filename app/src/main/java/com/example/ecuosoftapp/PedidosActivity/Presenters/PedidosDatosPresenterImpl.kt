package com.example.ecuosoftapp.PedidosActivity.Presenters

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.Interactors.PedidosDatosInteractorImpl
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.View.PedidosDatosFragment
import com.example.ecuosoftapp.SearchFragment.Clientes

class PedidosDatosPresenterImpl(var view: PedidosDatosFragment) : PedidosDatosPresenter {

    private val interactor: PedidosDatosInteractor

    init { interactor= PedidosDatosInteractorImpl(this) }

    override fun SolicitarPedidoTrabajoPresenter(context: Context) {interactor.SolicitarPedidoTrabajoInteractor(context)}
    override fun CargarPedidoTrabajoPresenter(arraySpinner: ArrayAdapter<Clientes>) {view.CargarPedidosTrabajo(arraySpinner)}

    override fun OcultarElementosPresenter() {view.OcultarElementos()}
    override fun VisualizarElementosPresenter(sFechaHora: String){view.VisualizarElementos( sFechaHora)}
    override fun SolicitarPrioridadPTPresenter(context: Context) {
        //55
    }


}
