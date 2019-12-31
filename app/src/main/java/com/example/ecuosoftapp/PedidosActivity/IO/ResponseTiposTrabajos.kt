package com.example.ecuosoftapp.PedidosActivity.IO

import com.google.gson.annotations.SerializedName

data class ResponseTiposTrabajos(

	@field:SerializedName("DetalleTrabajo")
	val detalleTrabajo: String? = null,

	@field:SerializedName("CodigoObjetoSA")
	val codigoObjetoSA: String? = null,

	@field:SerializedName("CodigoTipoTrabajo")
	val codigoTipoTrabajo: String? = null
)