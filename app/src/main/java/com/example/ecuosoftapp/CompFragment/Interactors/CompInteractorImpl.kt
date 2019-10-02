package com.example.ecuosoftapp.CompFragment.Interactors

import android.content.Context
import com.example.ecuosoftapp.CompFragment.xml.ParserHandlerComp


class CompInteractorImpl(var presenter: CompPresenter): CompInteractor {

    override fun BuscarDatosInteractor(context: Context) {

        with(presenter){
            ShowProgressBarPresenter(true)
            ShowRecyclerViewPresenter(false)
            val parser = ParserHandlerComp()
            val istream = context.assets.open("Planilla.xml")
            LoadDatosRecyclerViewPresenter( parser.parse(istream))
            ListaEmpleadosPresenter(ParserHandlerComp().listaEmpleado())
            ListaEmpresasPresenter(ParserHandlerComp().listaEmpresa())
            ShowProgressBarPresenter(false)
            ShowRecyclerViewPresenter(true)
        }
    }
}