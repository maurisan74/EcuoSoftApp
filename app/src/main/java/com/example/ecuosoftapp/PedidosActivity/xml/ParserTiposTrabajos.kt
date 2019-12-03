package com.example.ecuosoftapp.PedidosActivity.xml

import kotlin.collections.ArrayList
private lateinit var proyectos: ArrayList<String>
private lateinit var empleado: ArrayList<String>

class ParserTiposTrabajos {
//    private var text: String? = null
//
//    fun parse(inputStream: InputStream): ArrayList<TiposdeTrabajos> {
//        val trabajos = ArrayList<TiposdeTrabajos>()
//        var detalleTrabajo =""
//        var trabajo: TiposdeTrabajos
//
//        try {
//            proyectos =ArrayList()
//            empleado =ArrayList()
//            val factory = XmlPullParserFactory.newInstance()
//            factory.isNamespaceAware = true
//            val parser = factory.newPullParser()
//            parser.setInput(inputStream, null)
//            var eventType = parser.eventType
//
//            while (eventType != XmlPullParser.END_DOCUMENT) {
//                val tagname = parser.name
//
//                when (eventType) {
//                    XmlPullParser.TEXT -> text = parser.text
//                    XmlPullParser.END_TAG ->
//                        if (tagname.equals("TiposTrabajos", ignoreCase = true)) {
//                            trabajo =
//                                TiposdeTrabajos(
//                                    detalleTrabajo
//                                )
//                            trabajos.add(trabajo)
//                        }else if (tagname.equals("DetalleTrabajo", ignoreCase = true)) {
//                            detalleTrabajo = text.toString()
//                        }
//                }
//                eventType = parser.next()
//            }
//        } catch (e: XmlPullParserException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//        return trabajos
//    }

}
