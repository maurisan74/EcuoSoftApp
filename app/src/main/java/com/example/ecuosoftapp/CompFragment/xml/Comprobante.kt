package com.example.ecuosoftapp.CompFragment.xml

data class Comprobante(
    var codigoEmpresa : String? = null,
    var codigoSucursal : String? = null,
    var numeroComprobante : String? = null,
    var sucursalDeposito : String? = null,
    var empleado: String? = null,
    var motivo: String? = null,
    var fechaComprobante: String? = null,
    var total: Float = 0.toFloat(),
    var imagen: Int = 0
)


//class Comprobante(codigoEmpresa:String,codigoSucursal:String,  numeroComprobante: String,sucursalDeposito:String,
//                  empleado:String,motivo: String,fechaComprobante:String, total: Float, imagen: Int) {
//
//    var codigoEmpresa ="0"
//    var codigoSucursal ="0"
//    var numeroComprobante =""
//    var sucursalDeposito =""
//    var empleado: String? = null
//    var motivo: String? = null
//    var fechaComprobante: String? = null
//    var total: Float = 0.toFloat()
//    var imagen: Int = 0
//
//    init{
//        this.codigoEmpresa=codigoEmpresa
//        this.codigoSucursal=codigoSucursal
//        this.numeroComprobante=numeroComprobante
//        this.sucursalDeposito=sucursalDeposito
//        this.empleado=empleado
//        this.motivo=motivo
//        this.fechaComprobante=fechaComprobante
//        this.total=total
//        this.imagen=imagen
//    }
//}