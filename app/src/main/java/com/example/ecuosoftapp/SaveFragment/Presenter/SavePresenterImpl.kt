package com.example.ecuosoftapp.SaveFragment.Presenter

import android.content.Context
import com.example.ecuosoftapp.SaveFragment.Interactors.SaveInteractorImpl
import com.example.ecuosoftapp.SaveFragment.Interfaces.SaveInteractor
import com.example.ecuosoftapp.SaveFragment.Interfaces.SavePresenter
import com.example.ecuosoftapp.SaveFragment.View.SaveFragment

class SavePresenterImpl(var view: SaveFragment): SavePresenter {
    override fun verificaDatosPresenter(server: String, usuario: String, clave: String) {
        //.
    }

    override fun showErrorDatosPresenter(error: String) {
        //.
    }

    val interactor: SaveInteractor
    init {
        interactor= SaveInteractorImpl(this)
    }
    override fun DeleteServerPresenter(serverSel: Int, context: Context) {
        interactor.DeleteServerInteractor(serverSel,  context)
    }
    override fun GetUserPresenter(serverSeleccionado: Int, context: Context) {
        interactor.GetUserInteractor(serverSeleccionado, context)
    }

    override fun LoadUserPresenter(server: String, usuario: String, clave: String, predeterminado: Boolean) {
        view.LoadUser(server, usuario, clave, predeterminado)
    }

    override fun SolicitaServersPresenter() {
        interactor.SolicitaServersInteractor()
    }

    override fun LoadServersPresenter(servers: Array<String>) {
        view.LoadServers(servers)
    }
    override fun showMesagePresenter(message: String) {
        view.showMesage(message)
    }
}