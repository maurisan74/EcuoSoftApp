package com.example.ecuosoftapp.CompFragment.Presenter

import android.content.Context
import com.example.ecuosoftapp.CompFragment.Interactors.CompInteractor
import com.example.ecuosoftapp.CompFragment.Interactors.CompInteractorImpl
import com.example.ecuosoftapp.CompFragment.Interactors.CompPresenter
import com.example.ecuosoftapp.CompFragment.View.CompFragment
import com.example.ecuosoftapp.CompFragment.xml.Comprobante

class CompPresenterImpl(var view: CompFragment): CompPresenter {
    private val interactor: CompInteractor
    init {
        interactor= CompInteractorImpl(this)
    }
    override fun BuscarDatosPresenter(context: Context) {
        interactor.BuscarDatosInteractor(context)
    }
    override fun LoadDatosRecyclerViewPresenter(comprobantes: ArrayList<Comprobante>) {
        view.LoadDatosRecyclerView(comprobantes)
    }
    override fun ListaEmpleadosPresenter(listEmple: ArrayList<String>) {
        view.ListaEmpleados(listEmple)
    }
    override fun ListaEmpresasPresenter(listEmp: ArrayList<String>) {
        view.ListaEmpresas(listEmp)
    }
    override fun ShowProgressBarPresenter(mostrar: Boolean) {
        view.ShowProgressBar(mostrar)
    }
    override fun ShowRecyclerViewPresenter(mostrar: Boolean) {
        view.ShowRecyclerView(mostrar)
    }
    override fun ShowErrorPresenter(mensaje: String) {
        view.ShowError(mensaje)
    }



}