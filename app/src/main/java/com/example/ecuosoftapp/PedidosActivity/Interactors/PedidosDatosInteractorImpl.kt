package com.example.ecuosoftapp.PedidosActivity.Interactors


import android.content.Context
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.SearchFragment.Clientes
import org.json.JSONArray
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*


class PedidosDatosInteractorImpl(var presenter: PedidosDatosPresenter) : PedidosDatosInteractor {


    override fun SolicitarPedidoTrabajoInteractor(context: Context) {
        //visualiza progress bar y oculta el resto de elemenetos hasta que termine la carga
        //presenter.OcultarElementosPresenter()
        //Busca la fecha y hora actual
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:MM", Locale.getDefault())
        val date = Date()


        val json : String
        val istream: InputStream = context.assets.open("Clientes.json")
        json=istream.bufferedReader().use{it.readText()}

        val lista = ArrayList<Clientes>()
        val jsonArreglo = JSONArray(json)
        for (i in 0 until jsonArreglo.length()) {
            val cli = Clientes()
            cli.Nombre=jsonArreglo.getJSONObject(i).getString("Nombre")
            lista.add(cli)
        }

        presenter.VisualizarElementosPresenter(dateFormat.format(date).toString())

//        }
    }
}
