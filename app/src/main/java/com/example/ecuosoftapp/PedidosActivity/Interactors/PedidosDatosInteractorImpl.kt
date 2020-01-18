package com.example.ecuosoftapp.PedidosActivity.Interactors

import android.app.Activity
import android.content.Context
import com.example.ecuosoftapp.Msje
import com.example.ecuosoftapp.PedidosActivity.IO.*
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

//lateinit var adapterClientes: SpinnerAdapterClientes
lateinit var adapterTrabajos: SpinnerAdapterTrabajos
lateinit var adapterEmpleados: SpinnerAdapterEmpleados

class PedidosDatosInteractorImpl(var presenter: PedidosDatosPresenter) : PedidosDatosInteractor {


    override fun interacturServerInteractor(context: Context) {
        presenter.obtenerDatosPresenter(true)
        //Busca la fecha y hora actual
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:MM", Locale.getDefault())
        val date = Date()
//        SystemClock.sleep(5000)
//        var responseClientes: ArrayList<ResponseClientes>
        var responseTrabajos: ArrayList<ResponseTiposTrabajos>
        var responseEmpleados: ArrayList<ResponseEmpleados>
            try {
//                val call: Call<List<ResponseClientes>> = PedidosApiAdapter.request.getClientes()
//                call.enqueue(object : Callback<List<ResponseClientes>> {
//                    override fun onResponse(
//                        call: Call<List<ResponseClientes>>,
//                        response: Response<List<ResponseClientes>>
//                    ) {
//                        if (response.isSuccessful) {
//                            responseClientes = ArrayList(response.body()!!)
//                            adapterClientes =
//                                SpinnerAdapterClientes(
//                                    context,
//                                    responseClientes
//                                )
//                        }
//                    }
//                    override fun onFailure(call: Call<List<ResponseClientes>>, t: Throwable) {
//                        context.Msje("Error de RED o INTERNET. Intente en unos segundos.") } })



                val call01: Call<List<ResponseEmpleados>> = PedidosApiAdapter.request.getEmpleados()
                call01.enqueue(object : Callback<List<ResponseEmpleados>> {
                    override fun onResponse(
                        call01: Call<List<ResponseEmpleados>>,
                        response: Response<List<ResponseEmpleados>>
                    ) {
                        if (response.isSuccessful) {
                            responseEmpleados = ArrayList(response.body()!!)
                            adapterEmpleados =
                                SpinnerAdapterEmpleados(
                                    context,
                                    responseEmpleados
                                )
                        }
                    }
                    override fun onFailure(call01: Call<List<ResponseEmpleados>>, t: Throwable) {
                        context.Msje("Error de RED o INTERNET. Intente en unos segundos.") } })





                val call2: Call<List<ResponseTiposTrabajos>> = PedidosApiAdapter.request.getTiposTrabajos()
                call2.enqueue(object : Callback<List<ResponseTiposTrabajos>> {
                    override fun onResponse(
                        call2: Call<List<ResponseTiposTrabajos>>,
                        response: Response<List<ResponseTiposTrabajos>>
                    ) {
                        if (response.isSuccessful) {
                            responseTrabajos = ArrayList(response.body()!!)
                            adapterTrabajos =
                                SpinnerAdapterTrabajos(
                                    context,
                                    responseTrabajos
                                )
//                                presenter.cargarDatosPresenter(
//                                        false,
//                            dateFormat.format(date).toString(),
//                            adapterClientes, adapterTrabajos,adapterEmpleados
//                            )
                            presenter.cargarDatosPresenter(
                                false,
                                dateFormat.format(date).toString(),
                                 adapterTrabajos,adapterEmpleados
                            )
                        }
                    }
                    override fun onFailure(call: Call<List<ResponseTiposTrabajos>>, t: Throwable) {
                        context.Msje("Error de RED o INTERNET. Intente en unos segundos.") }
                })
            } catch (e: Exception) {
            } catch (e: Error) {
            } finally {
                presenter.obtenerDatosPresenter(false)
            }
    }
}



