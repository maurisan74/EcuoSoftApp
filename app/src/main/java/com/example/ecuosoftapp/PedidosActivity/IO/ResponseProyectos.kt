package com.example.ecuosoftapp.PedidosActivity.IO

import com.google.gson.annotations.SerializedName

data class ResponseProyectos(

	@field:SerializedName("NombreProyecto")
	val nombreProyecto: String? = null,

	@field:SerializedName("CodigoProyecto")
	val codigoProyecto: String? = null,

	@field:SerializedName("CodigoCompuesto")
	val codigoCompuesto: String? = null,

	@field:SerializedName("NombreCompleto")
	val nombreCompleto: String? = null
)