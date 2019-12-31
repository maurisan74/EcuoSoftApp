package com.example.ecuosoftapp.PedidosActivity.IO

import com.google.gson.annotations.SerializedName

data class ResponseInstalaciones(

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("CodigoEquipoInstalacion")
	val codigoEquipoInstalacion: String? = null
)