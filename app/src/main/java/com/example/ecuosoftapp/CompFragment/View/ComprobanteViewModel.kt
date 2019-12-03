package com.example.ecuosoftapp.CompFragment.View

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecuosoftapp.CompFragment.xml.Comprobante

class ComprobanteViewModel: ViewModel() {
    val comprobanteSeleccionado: MutableLiveData<Comprobante> = MutableLiveData()

    fun setComprobante(comprobante: Comprobante) {
        comprobanteSeleccionado.value = comprobante
    }
}