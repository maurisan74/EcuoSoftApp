package com.example.ecuosoftapp.xml

class DetalleComp(CodigoEmpresa: String, CodigoSucursal: String,NroSerieComprobante: String, NumeroComprobante:String, CodigoArticuloServicio:String,
                  Tipo:String, Rubro:String, ArticuloServicio:String, Cantidad:String, UnidadMedida:String, ValorUnitarioDescuento:String,
                  TotalLineaDescuento:String, Observacion:String) {
    var CodigoEmpresa=""
    var CodigoSucursal=""
    var NroSerieComprobante=""
    var NumeroComprobante=""
    var CodigoArticuloServicio =""
    var Tipo =""
    var Rubro =""
    var ArticuloServicio =""
    var Cantidad=""
    var UnidadMedida=""
    var ValorUnitarioDescuento=""
    var TotalLineaDescuento=""
    var Observacion=""

    init{
        this.CodigoEmpresa=CodigoEmpresa
        this.CodigoSucursal=CodigoSucursal
        this.NroSerieComprobante=NroSerieComprobante
        this.NumeroComprobante=NumeroComprobante
        this.CodigoArticuloServicio=CodigoArticuloServicio
        this.Tipo=Tipo
        this.Rubro=Rubro
        this.ArticuloServicio=ArticuloServicio
        this.Cantidad=Cantidad
        this.UnidadMedida=UnidadMedida
        this.ValorUnitarioDescuento=ValorUnitarioDescuento
        this.TotalLineaDescuento=TotalLineaDescuento
        this.Observacion=Observacion
    }
}