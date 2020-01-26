package com.example.ecuosoftapp.PedidosActivity.ModeloPedidos

import com.google.gson.annotations.SerializedName

data class ResponseEquipos(

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("Modelo")
	val modelo: String? = null,

	@field:SerializedName("CodigoEquipoInstalacion")
	val codigoEquipoInstalacion: String? = null
)