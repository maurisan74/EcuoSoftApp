package com.example.ecuosoftapp.PedidosActivity.Interactors

import android.content.Context
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.xml.ParserTiposTrabajos
import com.example.ecuosoftapp.PedidosActivity.xml.TiposdeTrabajos
import com.example.ecuosoftapp.R
import com.google.gson.Gson
import org.json.JSONArray
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class PedidosDatosInteractorImpl(var presenter: PedidosDatosPresenter) : PedidosDatosInteractor {


    override fun BuscarPrioridadesPT(context: Context) {

        ArrayAdapter.createFromResource(context,R.array.prioridad,R.layout.spinner_item).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            presenter.CargarPrioridadPTPresenter(adapter)
        }
    }
    override fun CargarFechaHoraInteractor() {
        presenter.OcultarElementosPresenter()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:MM", Locale.getDefault())
        val date = Date()
        presenter.CargarFechaHoraActualPresenter(dateFormat.format(date))
    }
    override fun SolicitarPedidoTrabajoInteractor(context: Context) {

        val json : String
        val arrOfString = arrayListOf<String>()

        val istream: InputStream = context.assets.open("TiposTrabajos.json")
        json=istream.bufferedReader().use{it.readText()}
        val jsonArray = JSONArray(json)
        for(i in 0..jsonArray.length()-1){
            val jsonObj=jsonArray.getJSONObject(i)
            arrOfString.add(jsonObj.getString("DetalleTrabajo"))
        }
        val arraySpinner=ArrayAdapter(context,R.layout.spinner_item,arrOfString)

        with(presenter){
//            val TiposTrabajos: ArrayList<TiposdeTrabajos>
//            val parser = ParserTiposTrabajos()
//
//            TiposTrabajos=parser.parse(istream)
//
//
////            spTipoTrabajo.adapter=adapter


            //        val userJson = ("[{'name': 'Alex','id': 1}, "
//                + "{'name': 'Brian','id':2}, "
//                + "{'name': 'Charles','id': 3}]")
//
            val gson = Gson()
//
//        val userArray = gson.fromJson<Array<Clientes>>(userJson, Array<Clientes>::class.java)
//
//        val reader = JsonReader(FileReader("TiposTrabajos.json"))
//        val data: Clientes = gson.fromJson(reader, Clientes::class.java)

//        spSolicitanteCc.adapter=data.toString()

            CargarPedidoTrabajoPresenter(arraySpinner)
            presenter.VisualizarElementosPresenter()

        }
    }

    override fun ShowElemns() {
//        with(presenter) {
//            HideProgressBarPresenter()
//            ShowNestedScrollViewPresenter()
//        }
    }
}
