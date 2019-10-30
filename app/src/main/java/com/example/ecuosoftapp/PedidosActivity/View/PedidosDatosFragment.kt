package com.example.ecuosoftapp.PedidosActivity.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosView
import com.example.ecuosoftapp.PedidosActivity.Presenters.PedidosDatosPresenterImpl
import kotlinx.android.synthetic.main.fragment_pedidos_datos.*

class PedidosDatosFragment : PedidosDatosView, Fragment() {
        lateinit var presentador: PedidosDatosPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.example.ecuosoftapp.R.layout.fragment_pedidos_datos,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentador = PedidosDatosPresenterImpl(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        SolicitarFechaHoraActual()
        SolicitarPrioridadPT()
        SolicitarMaestrosPT()
    }
    override fun ShowProgressBar(mostrar: Boolean) {
       if (mostrar) pbPrevio.visibility=View.VISIBLE
       else  pbPrevio.visibility=View.GONE
    }
    override fun SolicitarFechaHoraActual() {presentador.SolicitarFechaHoraActualPresenter()}
    override fun CargarFechaHoraActual(sFechaHora: String) {tvtime.text=sFechaHora}

    override fun SolicitarPrioridadPT() { presentador.SolicitarPrioridadPTPresenter(activity!!) }
    override fun CargarPrioridadPT(listaDePrioridades: ArrayAdapter<CharSequence>) {spPrioridad.adapter=listaDePrioridades}

    override fun SolicitarMaestrosPT() { presentador.SolicitarMaestrosPTPresenter()}
}
