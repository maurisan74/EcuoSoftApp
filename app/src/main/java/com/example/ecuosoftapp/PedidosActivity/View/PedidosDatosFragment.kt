package com.example.ecuosoftapp.PedidosActivity.View

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.SystemClock.sleep
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosView
import com.example.ecuosoftapp.PedidosActivity.Presenters.PedidosDatosPresenterImpl
import com.example.ecuosoftapp.R
import kotlinx.android.synthetic.main.fragment_pedidos_datos.*

class PedidosDatosFragment : PedidosDatosView, Fragment() {
    lateinit var presentador: PedidosDatosPresenter
    lateinit var dialog: Dialog


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
        presentador.interacturServerInteractor(context!!)

    }

    override fun obtenerDatos(visibilidad: Boolean) {
        ventanaEmergente(visibilidad, context!!)
    }


    override fun cargarDatos(visibilidad: Boolean, sFechaHora: String, adapterClientes: SpinnerAdapterClientes, adapterTrabajos: SpinnerAdapterTrabajos) {
        ventanaEmergente(visibilidad, context!!)
        tvtime.text = sFechaHora
        spSolicitanteCliente.adapter = adapterClientes
        spTipoTrabajo.adapter=adapterTrabajos
    }
    fun ventanaEmergente(visibilidad: Boolean, context: Context) {
        if (visibilidad) {
            dialog= Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.ventana_emergente)
            dialog.setCancelable(false)
//        val bac = object : Thread() {
//            override fun run() {
//                try {
//                    sleep(4000)
//                    dialog.dismiss()
//
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            }
//        }
//        bac.start()
            val txt =dialog.findViewById<View>(R.id.btnCancelarCarga)
            txt.isEnabled=true
            txt.setOnClickListener {
                dialog .dismiss()
            }

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.show()
        } else {
            dialog.dismiss()
        }
    }
}

