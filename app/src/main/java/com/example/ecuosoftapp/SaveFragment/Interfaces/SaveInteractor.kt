package com.example.ecuosoftapp.SaveFragment.Interfaces

import android.content.Context

interface SaveInteractor {
    fun SolicitaServersInteractor()
    fun GetUserInteractor(serverSeleccionado: Int, context: Context)

}