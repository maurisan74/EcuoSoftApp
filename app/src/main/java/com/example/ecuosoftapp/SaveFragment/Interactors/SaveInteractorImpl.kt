package com.example.ecuosoftapp.SaveFragment.Interactors

import android.content.Context
import android.content.SharedPreferences
import com.example.ecuosoftapp.SaveFragment.Interfaces.SaveInteractor
import com.example.ecuosoftapp.SaveFragment.Interfaces.SavePresenter
import kotlinx.android.synthetic.main.fragment_save.*

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
    override fun guardaDatosInteractor(servidor: String, usuario: String, clave: String, predeterminado: Boolean, context: Context, serverSel: Int) {
        sharedPreferences=context.getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        var server=""
        var us=""
        var cl=""
        var usurioOK=false
        var claveOK=false
        var serverOK=false
        var esPredeterminado=""


        if (servidor.isEmpty() or servidor.isBlank()) {
                presenter.showErrorServidorPresenter("Server No Valido")
        }else{
            server=servidor.trim()
            serverOK=true
        }

        if (usuario.isEmpty() or usuario.isBlank()) {
            presenter.showErrorUsuarioPresenter("Usuario Incorrecto")
        }else{
            us = usuario.trim()
            usurioOK=true
        }

        if (clave.isEmpty() or clave.isBlank()) {
            presenter.showErrorClavePresenter("Clave Incorrecta")

        }else{
            cl=clave.trim()
            claveOK=true
        }

        if(predeterminado)esPredeterminado="OK" else esPredeterminado=""


        if (serverOK && usurioOK && claveOK ) {
            when (serverSel) {
                0 -> {
                    editor?.putString("a", server)
                    editor?.putString("b", us)
                    editor?.putString("c", cl)
                    if (esPredeterminado=="OK") {
                        editor?.putString("x", esPredeterminado)
                        editor?.putString("y", "")
                        editor?.putString("z", "")
                    }else editor?.putString("x", "")
                }
                1 -> {
                    editor?.putString("d", server)
                    editor?.putString("e", us)
                    editor?.putString("f", cl)
                    if (esPredeterminado=="OK") {
                        editor?.putString("y", esPredeterminado)
                        editor?.putString("x", "")
                        editor?.putString("z", "")
                    }else editor?.putString("y", "")
                }
                2-> {
                    editor?.putString("g", server)
                    editor?.putString("h", us)
                    editor?.putString("i", cl)
                    if (esPredeterminado=="OK") {
                        editor?.putString("z", esPredeterminado)
                        editor?.putString("y", "")
                        editor?.putString("x", "")
                    }else editor?.putString("z", "")
                }
            }
            editor?.apply()
            editor.commit()
            presenter.showMesagePresenter("!Datos Registrados¡")
        }
    }
}