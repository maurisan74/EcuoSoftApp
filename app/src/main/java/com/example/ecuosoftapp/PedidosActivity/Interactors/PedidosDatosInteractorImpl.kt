package com.example.ecuosoftapp.PedidosActivity.Interactors

import android.content.Context
import android.os.SystemClock
import com.example.ecuosoftapp.Msje
import com.example.ecuosoftapp.PedidosActivity.IO.PedidosApiAdapter
import com.example.ecuosoftapp.PedidosActivity.IO.ResponseClientes
import com.example.ecuosoftapp.PedidosActivity.IO.ResponseTiposTrabajos
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapterClientes
import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapterTrabajos
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

lateinit var adapterClientes: SpinnerAdapterClientes
lateinit var adapterTrabajos: SpinnerAdapterTrabajos

class PedidosDatosInteractorImpl(var presenter: PedidosDatosPresenter) : PedidosDatosInteractor {


    override fun interacturServerInteractor(context: Context) {

        presenter.obtenerDatosPresenter(true)
        //Busca la fecha y hora actual
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:MM", Locale.getDefault())
        val date = Date()

//        SystemClock.sleep(5000)
        var responseClientes: ArrayList<ResponseClientes>
        var responseTrabajos: ArrayList<ResponseTiposTrabajos>

        doAsync {
            try {
                val call: Call<List<ResponseClientes>> = PedidosApiAdapter.request.getClientes()
                call.enqueue(object : Callback<List<ResponseClientes>> {

                    override fun onResponse(
                        call: Call<List<ResponseClientes>>,
                        response: Response<List<ResponseClientes>>
                    ) {
                        if (response.isSuccessful) {
                            responseClientes = ArrayList(response.body()!!)
                            adapterClientes = SpinnerAdapterClientes(context, responseClientes)

                        }
                    }

                    override fun onFailure(call: Call<List<ResponseClientes>>, t: Throwable) {
                        context.Msje("Error de RED o INTERNET. Intente en unos segundos.") } })

                val call2: Call<List<ResponseTiposTrabajos>> = PedidosApiAdapter.request.getTiposTrabajos()
                call2.enqueue(object : Callback<List<ResponseTiposTrabajos>> {

                    override fun onResponse(
                        call2: Call<List<ResponseTiposTrabajos>>,
                        response: Response<List<ResponseTiposTrabajos>>
                    ) {
                        if (response.isSuccessful) {
                            responseTrabajos = ArrayList(response.body()!!)
                            adapterTrabajos = SpinnerAdapterTrabajos(context, responseTrabajos)

                            uiThread {
                                presenter.cargarDatosPresenter(
                                    false,
                                    dateFormat.format(date).toString(),
                                    adapterClientes, adapterTrabajos
                                )
                            }

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
}



