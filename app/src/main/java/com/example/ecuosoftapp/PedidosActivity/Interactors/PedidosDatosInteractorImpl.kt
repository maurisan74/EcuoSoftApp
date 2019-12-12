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


    override fun BuscarPrioridadesPT(context: Context) {
        //visualiza progress bar y oculta el resto de elemenetos hasta que termine la carga
        //presenter.OcultarElementosPresenter()
        //Busca la fecha y hora actual
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:MM", Locale.getDefault())
        val date = Date()

        //busca los datos del sppiner de propiedad en recursos
//        ArrayAdapter.createFromResource(context, R.array.prioridad, R.layout.spinner_item).also {
//                adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            presenter.CargarPrioridadPTPresenter(adapter,dateFormat.format(date))
//        }
    }

    override fun SolicitarPedidoTrabajoInteractor(context: Context) {

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
//        val a =  ArrayAdapter(context, R.layout.spinner_item, lista)
//        val gson = Gson()
//        val reader = JsonReader(FileReader("Clientes.json"))
       // val data: JsonArray = gson.fromJson(reader, Clientes::class.java)



        //presenter.CargarPedidoTrabajoPresenter(a)
        presenter.VisualizarElementosPresenter()

//        }
    }
}
