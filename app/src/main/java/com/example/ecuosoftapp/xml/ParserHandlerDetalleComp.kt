package com.example.ecuosoftapp.xml

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class ParserHandlerDetalleComp {
    private var text: String? = null

    fun parseando(inputStream: InputStream): ArrayList<DetalleComp> {

        val detalle = ArrayList<DetalleComp>()
        var sCodigoEmpresa=""
        var sCodigoSucursal=""
        var sNroSerieComprobante=""
        var sNumeroComprobante=""
        var sCodigoArticuloServicio =""
        var sTipo =""
        var sRubro =""
        var sArticuloServicio =""
        var sCantidad=""
        var sUnidadMedida=""
        var sValorUnitarioDescuento=""
        var sTotalLineaDescuento=""
        var sObservacion=""
        var detalleComp: DetalleComp


        try {
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType

            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagname = parser.name

                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG ->
                        if (tagname.equals("vtAutorizacionComprobantes_Detalle", ignoreCase = true)) {
                            detalleComp = DetalleComp(
                                sCodigoEmpresa,
                                sCodigoSucursal,
                                sNroSerieComprobante,
                                sNumeroComprobante,
                                sCodigoArticuloServicio,
                                sTipo,
                                sRubro,
                                sArticuloServicio,
                                sCantidad,
                                sUnidadMedida,
                                sValorUnitarioDescuento,
                                sTotalLineaDescuento,
                                sObservacion
                            )
                            detalle.add(detalleComp)
                        } else if (tagname.equals("CodigoEmpresa", ignoreCase = true)) {
                            sCodigoEmpresa=text!!.toString()
                        } else if (tagname.equals("CodigoSucursal", ignoreCase = true)) {
                            sCodigoSucursal=text!!.toString()
                        } else if (tagname.equals("NroSerieComprobante", ignoreCase = true)) {
                            sNroSerieComprobante=text!!.toString()
                        } else if (tagname.equals("NumeroComprobante", ignoreCase = true)) {
                            sNumeroComprobante=text!!.toString()
                        } else if (tagname.equals("CodigoArticuloServicio", ignoreCase = true)) {
                            sCodigoArticuloServicio =text.toString()
                        }else if (tagname.equals("Tipo", ignoreCase = true)) {
                            sTipo =text.toString()
                        }else if (tagname.equals("Rubro", ignoreCase = true)) {
                            sRubro =text.toString()
                        }else if (tagname.equals("ArticuloServicio", ignoreCase = true)) {
                            sArticuloServicio =text.toString()
                        }else if (tagname.equals("Cantidad", ignoreCase = true)) {
                            sCantidad =text.toString()
                        }else if (tagname.equals("UnidadMedida", ignoreCase = true)) {
                            sUnidadMedida =text.toString()
                        }else if (tagname.equals("ValorUnitarioDescuento", ignoreCase = true)) {
                            sValorUnitarioDescuento =text.toString()
                        }else if (tagname.equals("TotalLineaDescuento", ignoreCase = true)) {
                            sTotalLineaDescuento =text.toString()
                        }
                        else if (tagname.equals("Observacion", ignoreCase = true)) {
                            sObservacion =text.toString()
                        }
                }
                eventType = parser.next()
            }
        } catch (e:XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return detalle
    }
}


