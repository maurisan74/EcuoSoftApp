package com.example.ecuosoftapp.PedidosActivity.IO

import com.google.gson.annotations.SerializedName

data class ResponseClientes(

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("CodigoCliente")
	val codigoCliente: String? = null,

	@field:SerializedName("CodigoPersona")
	val codigoPersona: String? = null
)