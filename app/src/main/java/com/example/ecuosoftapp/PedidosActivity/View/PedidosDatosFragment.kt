package com.example.ecuosoftapp.PedidosActivity.View

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosView
import com.example.ecuosoftapp.PedidosActivity.Presenters.PedidosDatosPresenterImpl
import com.example.ecuosoftapp.R
import kotlinx.android.synthetic.main.fragment_pedidos_datos.*

class PedidosDatosFragment : PedidosDatosView, Fragment() {
    lateinit var presentador: PedidosDatosPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pedidos_datos, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentador = PedidosDatosPresenterImpl(this)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presentador.SolicitarFechaHoraActualPresenter()
        presentador.SolicitarPedidoTrabajoPresenter(context!!)
        presentador.SolicitarPrioridadPTPresenter(activity!!)
    }

    override fun OcultarElementos() {
        pbPrevio.visibility = View.VISIBLE
        tvProyecto.visibility = View.GONE
        spSolicitanteCc5.visibility = View.GONE
        spSolicitanteCc4.visibility = View.GONE
        radioGroup.visibility = View.GONE
        spSolicitanteCc3.visibility = View.GONE
        spSolicitanteCc2.visibility = View.GONE
        textView21.visibility = View.GONE
        spSolicitanteCc.visibility = View.GONE
        spPrioridad.visibility = View.GONE
        textView13.visibility = View.GONE
        textView18.visibility = View.GONE
        textView6.visibility = View.GONE
        textView12.visibility = View.GONE
        tvtime.visibility = View.GONE
        spTipoTrabajo.visibility = View.GONE
        textView17.visibility = View.GONE
        radioGroup3.visibility = View.GONE
        spSolicitanteEmpleado.visibility = View.GONE
        spSolicitanteCliente.visibility = View.GONE
        etDescTrabajo.visibility = View.GONE
        cvItem1.setBackgroundColor(Color.parseColor("#E0E0E0"))
        cvItem1.cardElevation=0f
    }

    override fun VisualizarElementos() {
        pbPrevio.visibility = View.GONE
        tvProyecto.visibility = View.VISIBLE
        spSolicitanteCc5.visibility = View.VISIBLE
        spSolicitanteCc4.visibility = View.VISIBLE
        radioGroup.visibility = View.VISIBLE
        spSolicitanteCc3.visibility = View.VISIBLE
        spSolicitanteCc2.visibility = View.VISIBLE
        textView21.visibility = View.VISIBLE
        spSolicitanteCc.visibility = View.VISIBLE
        spPrioridad.visibility = View.VISIBLE
        textView13.visibility = View.VISIBLE
        textView18.visibility = View.VISIBLE
        textView6.visibility = View.VISIBLE
        textView12.visibility = View.VISIBLE
        tvtime.visibility = View.VISIBLE
        spTipoTrabajo.visibility = View.VISIBLE
        textView17.visibility = View.VISIBLE
        radioGroup3.visibility = View.VISIBLE
        spSolicitanteEmpleado.visibility = View.VISIBLE
        spSolicitanteCliente.visibility = View.VISIBLE
        etDescTrabajo.visibility = View.VISIBLE
        cvItem1.setBackgroundColor(Color.parseColor("#DADADA"))
        cvItem1.cardElevation=4f
    }

    override fun CargarFechaHoraActual(sFechaHora: String) {
        tvtime.text = sFechaHora
    }
    override fun CargarPedidosTrabajo(arraySpinner: ArrayAdapter<String>) {
        spTipoTrabajo.adapter = arraySpinner
    }
    override fun CargarPrioridadPT(listaDePrioridades: ArrayAdapter<CharSequence>) {
        spPrioridad.adapter = listaDePrioridades
        spPrioridad.setSelection(2)
    }


}
