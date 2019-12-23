package com.example.ecuosoftapp.PedidosActivity.Presenters

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.Interactors.PedidosDatosInteractorImpl
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.View.PedidosDatosFragment
import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapter
import com.example.ecuosoftapp.SearchFragment.Clientes

class PedidosDatosPresenterImpl(var view: PedidosDatosFragment) : PedidosDatosPresenter {

    private val interactor: PedidosDatosInteractor

    init { interactor= PedidosDatosInteractorImpl(this) }

    override fun interacturServerInteractor(context: Context) {interactor.interacturServerInteractor(context)}
    override fun cargarDatosPresenter(visibilidad: Boolean,sFechaHora: String, adapter: SpinnerAdapter) {view.cargarDatos(visibilidad, sFechaHora, adapter)}

   override fun obtenerDatosPresenter(visibilidad: Boolean) {view.obtenerDatos(visibilidad)}

}
