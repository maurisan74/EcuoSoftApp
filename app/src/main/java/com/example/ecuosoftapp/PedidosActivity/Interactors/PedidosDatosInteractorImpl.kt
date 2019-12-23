package com.example.ecuosoftapp.PedidosActivity.Interactors


import android.content.Context
import android.util.Log
import com.example.ecuosoftapp.ApiUtils
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosInteractor
import com.example.ecuosoftapp.PedidosActivity.Interfaces.PedidosDatosPresenter
import com.example.ecuosoftapp.PedidosActivity.PojosRetrofit.EndPoints
import com.example.ecuosoftapp.PedidosActivity.PojosRetrofit.ResponseClientes
import com.example.ecuosoftapp.PedidosActivity.View.SpinnerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class PedidosDatosInteractorImpl(var presenter: PedidosDatosPresenter) : PedidosDatosInteractor {
    lateinit var adapter: SpinnerAdapter
    override fun interacturServerInteractor(context: Context) {

        presenter.obtenerDatosPresenter(true)
        //visualiza progress bar y oculta el resto de elemenetos hasta que termine la carga
        //presenter.OcultarElementosPresenter()
        //Busca la fecha y hora actual
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:MM", Locale.getDefault())
        val date = Date()


//        var responseClientes: ArrayList<ResponseClientes>
//        val retrofit = Retrofit.Builder()
//            .baseUrl(ApiUtils.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val request = retrofit.create(EndPoints::class.java)
//        try {
//            val call: Call<List<ResponseClientes>> = request.getClientes()
//            call.enqueue(object : Callback<List<ResponseClientes>> {
//                override fun onFailure(call: Call<List<ResponseClientes>>, t: Throwable) {
//                }
//                override fun onResponse(
//                    call: Call<List<ResponseClientes>>,
//                    response: Response<List<ResponseClientes>>
//                ) {
//                    if (response.code() == 200) {
//                        responseClientes = ArrayList(response.body()!!)
//                        adapter = SpinnerAdapter(context, responseClientes)
//
//                    }
//                }
//            })
//        } catch (e: Exception) {
//            Log.e("Error", "catch")
//
//        }




        presenter.cargarDatosPresenter(false, dateFormat.format(date).toString(),adapter)
    }
}
