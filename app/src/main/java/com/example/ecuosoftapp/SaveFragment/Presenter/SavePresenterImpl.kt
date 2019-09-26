package com.example.ecuosoftapp.SaveFragment.Presenter

import android.content.Context
import com.example.ecuosoftapp.SaveFragment.Interactors.SaveInteractorImpl
import com.example.ecuosoftapp.SaveFragment.Interfaces.SaveInteractor
import com.example.ecuosoftapp.SaveFragment.Interfaces.SavePresenter
import com.example.ecuosoftapp.SaveFragment.View.SaveFragment

class SavePresenterImpl(var view: SaveFragment): SavePresenter {
    override fun showErrorServidorPresenter(error: String) {
        view.showErrorServidor(error)
    }

    override fun showErrorUsuarioPresenter(error: String) {
        view.showErrorUsuario(error)
    }

    override fun showErrorClavePresenter(error: String) {
        view.showErrorClave(error)
    }

    private val interactor: SaveInteractor
    init {
        interactor= SaveInteractorImpl(this)
    }

    override fun guardaDatosPresenter(servidor: String, usuario: String, clave: String,predeterminado: Boolean, context: Context, serverSel: Int) {
        interactor.guardaDatosInteractor(servidor, usuario, clave,predeterminado, context,serverSel)
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