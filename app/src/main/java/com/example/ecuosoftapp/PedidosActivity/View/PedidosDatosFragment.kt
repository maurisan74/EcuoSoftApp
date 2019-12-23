package com.example.ecuosoftapp.PedidosActivity.View

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.ecuosoftapp.ApiUtils.BASE_URL
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosView
import com.example.ecuosoftapp.PedidosActivity.PojosRetrofit.EndPoints
import com.example.ecuosoftapp.PedidosActivity.PojosRetrofit.ResponseClientes
import com.example.ecuosoftapp.PedidosActivity.Presenters.PedidosDatosPresenterImpl
import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.SearchFragment.Clientes
import kotlinx.android.synthetic.main.fragment_pedidos_datos.*
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        var responseClientes: ArrayList<ResponseClientes>
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.101:3000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val request = retrofit.create(EndPoints::class.java)
        doAsync {
            try {
                val call: Call<List<ResponseClientes>> = request.getClientes()
                call.enqueue(object : Callback<List<ResponseClientes>> {
                    override fun onResponse(call: Call<List<ResponseClientes>>, response: Response<List<ResponseClientes>>) {
                        if (response.code() == 200) {
                            responseClientes = ArrayList(response.body()!!)
                            val adapter = SpinnerAdapter(activity!!, responseClientes)
                            spSolicitanteCliente.adapter = adapter
                        }
                    }

                    override fun onFailure(call: Call<List<ResponseClientes>>, t: Throwable) {
                    }
                })
            } catch (e: Exception) {
                Log.e("Error", "catch")

            }
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presentador.interacturServerInteractor(context!!)
    }

    override fun obtenerDatos(visibilidad: Boolean) {
        ventanaEmergente(visibilidad, context!!)
    }


    override fun cargarDatos(visibilidad: Boolean, sFechaHora: String, array: SpinnerAdapter) {
        ventanaEmergente(visibilidad, context!!)
        tvtime.text = sFechaHora
        spSolicitanteCliente.adapter = array
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

