package com.example.ecuosoftapp.SaveFragment.Interactors

import android.content.Context
import android.content.SharedPreferences
import com.example.ecuosoftapp.SaveFragment.Interfaces.SaveInteractor
import com.example.ecuosoftapp.SaveFragment.Interfaces.SavePresenter

class SaveInteractorImpl(var presenter: SavePresenter): SaveInteractor {

    lateinit var sharedPreferences: SharedPreferences
    private var server=""
    private var usuario=""
    private var clave=""
    private var predeterminado: Boolean=false

    override fun GetUserInteractor(serverSeleccionado: Int, context: Context) {
        sharedPreferences=context.getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        when (serverSeleccionado) {
            0 -> {
                if (sharedPreferences.contains("a")) server = sharedPreferences.getString("a", "").toString()
                if (sharedPreferences.contains("b")) usuario = sharedPreferences.getString("b", "").toString()
                if (sharedPreferences.contains("c")) clave = sharedPreferences.getString("c", "").toString()
                predeterminado = sharedPreferences.getString("x", "") == "OK"
            }
            1 -> {
                if (sharedPreferences.contains("d")) server = sharedPreferences.getString("d", "").toString()
                if (sharedPreferences.contains("e")) usuario = sharedPreferences.getString("e", "").toString()
                if (sharedPreferences.contains("f")) clave = sharedPreferences.getString("f", "").toString()
                predeterminado = sharedPreferences.getString("y", "") == "OK"
            }
            2 -> {
                if (sharedPreferences.contains("g")) server = sharedPreferences.getString("g", "").toString()
                if (sharedPreferences.contains("h")) usuario = sharedPreferences.getString("h", "").toString()
                if (sharedPreferences.contains("i")) clave = sharedPreferences.getString("i", "").toString()
                predeterminado = sharedPreferences.getString("z", "") == "OK"
            }
        }
        presenter.LoadUserPresenter(server, usuario, clave, predeterminado)
    }

    override fun SolicitaServersInteractor() {
        presenter.LoadServersPresenter((arrayOf("Primer Servidor", "Segundo Servidor", "Tercer Servidor")))
    }
    override fun DeleteServerInteractor(serverSel: Int, context: Context) {
        sharedPreferences=context.getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        when (serverSel) {
            0 -> {
                editor?.putString("a", "")
                editor?.putString("b", "")
                editor?.putString("c", "")
                editor?.putString("x", "")
            }
            1 -> {
                editor?.putString("d", "")
                editor?.putString("e", "")
                editor?.putString("f", "")
                editor?.putString("y", "")
            }
            2-> {
                editor?.putString("g", "")
                editor?.putString("h", "")
                editor?.putString("i", "")
                editor?.putString("z", "")
            }
        }
        editor?.apply()
        editor.commit()
        presenter.showMesagePresenter("¡Datos Eliminados!")
    }
    override fun verificaDatosInteractor(server: String, usuario: String, clave: String) {
       //nada
    }




}