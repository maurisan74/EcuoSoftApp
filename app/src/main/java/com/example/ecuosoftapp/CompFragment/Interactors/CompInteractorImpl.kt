package com.example.ecuosoftapp.CompFragment.Interactors

import android.content.Context
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecuosoftapp.CompFragment.Modelo.ResponseCompHead
import com.example.ecuosoftapp.CompFragment.View.AdapterLanding
import com.example.ecuosoftapp.CompFragment.xml.ParserHandlerComp
import com.example.ecuosoftapp.IO.ApiAdapter
import com.example.ecuosoftapp.Msje
import com.example.ecuosoftapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompInteractorImpl(var presenter: CompPresenter) : CompInteractor {

    override fun BuscarDatosInteractor(context: Context) {

        with(presenter) {
            ShowProgressBarPresenter(true)
            ShowRecyclerViewPresenter(false)
            var responseCompHead: ArrayList<ResponseCompHead>

            try {
                val call: Call<List<ResponseCompHead>> = ApiAdapter.request.getCompHead()
                call.enqueue(object : Callback<List<ResponseCompHead>> {
                    override fun onResponse(
                        call: Call<List<ResponseCompHead>>,
                        response: Response<List<ResponseCompHead>>
                    ) {
                        if (response.isSuccessful) {
                            responseCompHead = ArrayList(response.body()!!)
                           // adapterCompHead = AdapterLanding(responseCompHead)




                            LoadDatosRecyclerViewPresenter(responseCompHead)
                        }
                    }

                    override fun onFailure(call: Call<List<ResponseCompHead>>, t: Throwable) {
                        context.Msje("Error de RED o INTERNET. Intente en unos segundos.")
                    }
                })

            } catch (e: Exception) {
            } catch (e: Error) {
            } finally {
                ShowProgressBarPresenter(false)
                ShowRecyclerViewPresenter(true)
            }


//            val parser = ParserHandlerComp()
//            val istream = context.assets.open("Planilla.xml")



//            ListaEmpleadosPresenter(ParserHandlerComp().listaEmpleado())
//
//            ListaEmpresasPresenter(ParserHandlerComp().listaEmpresa())


//            ShowProgressBarPresenter(false)
//            ShowRecyclerViewPresenter(true)
        }


    }
}