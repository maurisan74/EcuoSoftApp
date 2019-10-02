package com.example.ecuosoftapp.DetalleFragment.Interactors

import android.content.Context
import com.example.ecuosoftapp.DetalleFragment.Interfaces.DetalleInteractor

import com.example.ecuosoftapp.DetalleFragment.View.DetalleFragment
import com.example.ecuosoftapp.DetalleFragment.xml.DetalleComp
import com.example.ecuosoftapp.DetalleFragment.xml.ParserHandlerDetalleComp

class DetalleInteractorImpl(var presenter: DetalleFragment):DetalleInteractor {

    override fun BuscarDatosPresenterInteractpr(context: Context) {
        val adetalleComp: ArrayList<DetalleComp>
        presenter.ShowRecyclerView(false)
        presenter.ShowProgressBar(true)
        try {
            val parser = ParserHandlerDetalleComp()
            val istream = context.assets.open("Planilla.xml")

            adetalleComp = parser.parseando(istream)
            presenter.ShowdatosRecyclerView(adetalleComp)
            presenter.ShowProgressBar(false)
            presenter.ShowRecyclerView(true)
        }catch (e: Exception ){
            presenter.ShowError("No se pudo conectar al servidor, Intente de nuevo")
        }

    }
}