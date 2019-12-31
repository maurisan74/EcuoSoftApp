package com.example.ecuosoftapp.PedidosActivity.IO

import com.google.gson.annotations.SerializedName

data class ResponseEquipos(

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("Modelo")
	val modelo: String? = null,

	@field:SerializedName("CodigoEquipoInstalacion")
	val codigoEquipoInstalacion: String? = null
)