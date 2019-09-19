package com.example.ecuosoftapp.SaveFragment.Interfaces

interface SaveView {
    fun LoadServers(servers: Array<String>)
    fun LoadUser(server: String, user: String, password: String, default: Boolean)
    fun ShowPassword(resultado: String)
    fun ShowSerPre(resultado: String)
    fun ShowMensaje(resultado: String)

}