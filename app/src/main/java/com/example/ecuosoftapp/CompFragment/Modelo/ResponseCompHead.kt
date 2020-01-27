package com.example.ecuosoftapp.CompFragment.Modelo

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel

@Keep
data class ResponseCompHead(

	@SerializedName("CodigoEmpresa")
	var codigoEmpresa: String, // 2
	@SerializedName("CodigoSucursal")
	var codigoSucursal: String, // 3
	@SerializedName("CodigoTipoComprobante")
	var codigoTipoComprobante: String, // 12
	@SerializedName("Contrato")
	var contrato: String?, // null
	@SerializedName("SucursalDeposito")
	var sucursalDeposito: String, // Libreria y Servicios a Bordo Diamante
	@SerializedName("Empleado")
	var empleado: String, // Bruno Fabricio Ramon
	@SerializedName("Empresa")
	var empresa: String, // C.A.T.A. Internacional Limitada
	@SerializedName("FechaComprobante")
	var fechaComprobante: String, // 2019-02-04T16:21:00-03:00
	@SerializedName("Motivo")
	var motivo: String, // Faltante en stock
	@SerializedName("NroComprobanteCompleto")
	var nroComprobanteCompleto: String, // NPI  : 0001-00001214
	@SerializedName("NroSerieComprobante")
	var nroSerieComprobante: String, // 1
	@SerializedName("NumeroComprobante")
	var numeroComprobante: String, // 1214
	@SerializedName("Oportunidad")
	var oportunidad: Any?, // null
	@SerializedName("Proyecto")
	var proyecto: Any?, // null
	@SerializedName("TipoComprobante")
	var tipoComprobante: String, // Orden de compra Proveedor
	@SerializedName("Total")
	var total: String, // 1202.87
	@IgnoredOnParcel
	var imagen: Int // 1202.87
)