package com.example.ecuosoftapp.SaveFragment.Interfaces

interface SaveView {
    fun LoadServers(servers: Array<String>)
    fun LoadUser(server: String, user: String, password: String, default: Boolean)

    fun showMesage(message: String)

    fun showErrorDatos(error: String)


}