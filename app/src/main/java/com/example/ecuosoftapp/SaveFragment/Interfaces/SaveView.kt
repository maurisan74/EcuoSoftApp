package com.example.ecuosoftapp.SaveFragment.Interfaces

interface SaveView {
    fun LoadServers(servers: Array<String>)
    fun LoadUser(server: String, user: String, password: String, default: Boolean)
    fun showErrorServidor(error: String)
    fun showErrorUsuario(error: String)
    fun showErrorClave(error: String)

    fun showMesage(message: String)


}