package com.example.ecuosoftapp.DetalleFragment.Presenter

import android.content.Context
import com.example.ecuosoftapp.DetalleFragment.Interactors.DetalleInteractorImpl
import com.example.ecuosoftapp.DetalleFragment.Interfaces.DetalleInteractor
import com.example.ecuosoftapp.DetalleFragment.Interfaces.DetallePresenter
import com.example.ecuosoftapp.DetalleFragment.View.DetalleFragment
import com.example.ecuosoftapp.DetalleFragment.xml.DetalleComp

class DetallePresenterImpl(var view: DetalleFragment): DetallePresenter {

    private val interactor: DetalleInteractor
    init {
        interactor= DetalleInteractorImpl(view)
    }

    override fun ShowRecyclerViewPresenter(mostrar: Boolean) {
        view.ShowRecyclerView(mostrar)
    }
    override fun ShowdatosRecyclerViewPresenter(adetalleComp: ArrayList<DetalleComp>) {
        view.ShowdatosRecyclerView(adetalleComp)
    }

    override fun ShowErrorPresenter(mensaje: String) {
        view.ShowError(mensaje)
    }

    override fun BuscarDatosPresenter(context: Context) {
        interactor.BuscarDatosPresenterInteractpr(context)
    }

    override fun ShowProgressBarPresenter(mostrar: Boolean) {
        view.ShowProgressBar(mostrar)
    }
}