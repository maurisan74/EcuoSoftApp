package com.example.ecuosoftapp.CompFragment.Presenter

import com.example.ecuosoftapp.CompFragment.Interactors.CompInteractor
import com.example.ecuosoftapp.CompFragment.Interactors.CompInteractorImpl
import com.example.ecuosoftapp.CompFragment.Interactors.CompPresenter
import com.example.ecuosoftapp.CompFragment.View.CompFragment
import com.example.ecuosoftapp.xml.Comprobante


class CompPresenterImpl(var view: CompFragment): CompPresenter {
    override fun ShowRecyclerViewPresenter(mostrar: Boolean) {
        view.ShowRecyclerView(mostrar)
    }

    private val interactor: CompInteractor
    init {
        interactor= CompInteractorImpl(this)
    }

    override fun ShowProgressBarPresenter(mostrar: Boolean) {
        view.ShowProgressBar(mostrar)
    }

    override fun ShowdatosRecyclerViewPresenter(adetalleComp: ArrayList<Comprobante>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ShowErrorPresenter(mensaje: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}