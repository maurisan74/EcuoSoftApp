package com.example.ecuosoftapp.SaveFragment.Interfaces

import android.content.Context

interface SaveInteractor {
    fun SolicitaServersInteractor()
    fun GetUserInteractor(serverSeleccionado: Int, context: Context)

    fun DeleteServerInteractor(serverSel: Int, context: Context)

    fun guardaDatosInteractor(servidor: String, usuario: String, clave: String, predeterminado: Boolean, context: Context, serverSel: Int)
}