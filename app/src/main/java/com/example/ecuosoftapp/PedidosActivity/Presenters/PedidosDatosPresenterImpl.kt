package com.example.ecuosoftapp.PedidosActivity.Presenters

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.Interactors.PedidosDatosInteractorImpl
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.View.PedidosDatosFragment

class PedidosDatosPresenterImpl(var view: PedidosDatosFragment) : PedidosDatosPresenter {


    private val interactor: PedidosDatosInteractor

    init { interactor= PedidosDatosInteractorImpl(this) }

    override fun SolicitarPedidoTrabajoPresenter(context: Context) {interactor.SolicitarPedidoTrabajoInteractor(context)}
    override fun CargarPedidoTrabajoPresenter(listaPedidos: ArrayAdapter<CharSequence>) {view.CargarPedidosTrabajo(listaPedidos)}

    override fun ShowProgressBarPresenter(mostrar: Boolean) {view.ShowProgressBar(mostrar) }
    override fun ShowNestedScrollViewPresenter(mostrar: Boolean) {view.ShowNestedScrollView(mostrar) }
    override fun SolicitarFechaHoraActualPresenter() { interactor.CargarFechaHoraInteractor()}
    override fun CargarFechaHoraActualPresenter(sFechaHora: String) {view.CargarFechaHoraActual(sFechaHora)}

    override fun SolicitarPrioridadPTPresenter(context: Context) {interactor.BuscarPrioridadesPT(context)}
    override fun CargarPrioridadPTPresenter(listaDePrioridades: ArrayAdapter<CharSequence>) {view.CargarPrioridadPT(listaDePrioridades)}




}
