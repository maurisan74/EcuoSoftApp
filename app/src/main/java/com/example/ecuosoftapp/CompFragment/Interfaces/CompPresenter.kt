package com.example.ecuosoftapp.CompFragment.Interactors

import android.content.Context
import com.example.ecuosoftapp.CompFragment.Modelo.ResponseCompHead

interface CompPresenter {
    fun ShowProgressBarPresenter(mostrar: Boolean)
    fun ShowRecyclerViewPresenter(mostrar: Boolean)
    fun LoadDatosRecyclerViewPresenter(adapter2: ArrayList<ResponseCompHead>)
    fun ShowErrorPresenter(mensaje: String)
    fun ListaEmpleadosPresenter(listEmple: ArrayList <String>)
    fun ListaEmpresasPresenter(listEmp: ArrayList <String>)
    fun BuscarDatosPresenter(context: Context)

}
