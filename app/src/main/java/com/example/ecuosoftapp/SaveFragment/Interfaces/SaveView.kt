package com.example.ecuosoftapp.SaveFragment.Interfaces

interface SaveView {
    fun LoadServers(servers: Array<String>)
    fun ShowServer(resultado: String)
    fun ShowUser(resultado: String)
    fun ShowPassword(resultado: String)
    fun ShowSerPre(resultado: String)
    fun ShowMensaje(resultado: String)

}