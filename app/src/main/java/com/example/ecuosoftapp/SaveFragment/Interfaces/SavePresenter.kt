package com.example.ecuosoftapp.SaveFragment.Interfaces

import android.content.Context

interface SavePresenter {

    fun SolicitaServersPresenter()
    fun LoadServersPresenter(servers: Array<String>)

    fun DeleteServerPresenter(serverSel: Int, context: Context)
    fun showMesagePresenter(message: String)

    fun LoadUserPresenter(server: String, usuario: String, clave: String, predeterminado: Boolean)

    fun GetUserPresenter(serverSeleccionado: Int, context: Context )

    fun verificaDatosPresenter(server: String, usuario: String, clave: String)
    fun showErrorDatosPresenter(error: String)
}
