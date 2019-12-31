package com.example.ecuosoftapp.PedidosActivity.IO

import com.google.gson.annotations.SerializedName

data class ResponseEmpleados(

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("Legajo")
	val legajo: String? = null,

	@field:SerializedName("CodigoPersona")
	val codigoPersona: String? = null
)