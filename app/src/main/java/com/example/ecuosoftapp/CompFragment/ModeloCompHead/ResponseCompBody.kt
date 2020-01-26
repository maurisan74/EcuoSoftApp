package com.example.ecuosoftapp.CompFragment.ModeloCompHead

import com.google.gson.annotations.SerializedName

data class ResponseCompBody(

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("CodigoCliente")
	val codigoCliente: String? = null,

	@field:SerializedName("CodigoPersona")
	val codigoPersona: String? = null
)