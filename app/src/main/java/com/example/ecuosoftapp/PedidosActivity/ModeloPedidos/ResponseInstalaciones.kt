package com.example.ecuosoftapp.PedidosActivity.ModeloPedidos

import com.google.gson.annotations.SerializedName

data class ResponseInstalaciones(

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("CodigoEquipoInstalacion")
	val codigoEquipoInstalacion: String? = null
)