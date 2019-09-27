package com.example.ecuosoftapp.CompFragment.Interactors

import android.content.Context
import com.example.ecuosoftapp.xml.ParserHandlerComp


class CompInteractorImpl(var presenter: CompPresenter): CompInteractor {

    override fun BuscarDatosPresenterInteractpr(context: Context) {
        presenter.ShowProgressBarPresenter(true)
        presenter.ShowRecyclerViewPresenter(false)
        val parser = ParserHandlerComp()
        val istream = context.assets.open("Planilla.xml")
        presenter.ShowdatosRecyclerViewPresenter(parser.parse(istream))

    }

}