package com.example.ecuosoftapp.PedidosActivity.xml

import com.example.ecuosoftapp.DetalleFragment.xml.TiposTrabajos
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList
private lateinit var proyectos: ArrayList<String>
private lateinit var empleado: ArrayList<String>

class ParserHandlerComp {
    private var text: String? = null
    fun parse(inputStream: InputStream): ArrayList<TiposTrabajos> {
        var bPaso = false
        var bPaso2 = false
        val employees = ArrayList<TiposTrabajos>()
        var DetalleTrabajo =""
        var codSuc ="0"
        var numComp=""
        var sucDep = ""
        var empl = ""
        var motivo = ""
        var fecComp = ""
        var tot: Float = 0.toFloat()
        var employee: TiposTrabajos
        val imagen = 0
        var temp1=""
        var temp=""

        try {
            proyectos =ArrayList()
            empleado =ArrayList()
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
                        if (tagname.equals("vtAutorizacionComprobantes", ignoreCase = true)) {
                                employee = TiposTrabajos(
                                    DetalleTrabajo,
                                    codSuc,
                                    numComp,
                                    sucDep,
                                    empl,
                                    motivo,
                                    fecComp,
                                    tot,
                                    imagen
                                )
                                employees.add(employee)
                        } else if (tagname.equals("DetalleTrabajo", ignoreCase = true)) {
                            DetalleTrabajo=verificaLargo(text.toString())
//                            if(text.toString().length==1){
//                                codEmp ="0"+ text.toString()
//                            }
//                            else{
//                                codEmp = text.toString()
//                            }
                        } else if (tagname.equals("Proyectos", ignoreCase = true)) {
                            codSuc=verificaLargo(text.toString())
//                            if(text.toString().length==1){
//                                codSuc ="0"+ text.toString()
//                            }
//                            else{
//                                codSuc = text.toString()
//                            }
                            if (!bPaso){
                                temp1 = codSuc
                                proyectos.add(codSuc)
                                bPaso = true
                            } else{
                                if (temp1!=codSuc){
                                    var encontrada=false
                                    for (i in 0 until proyectos.size) {
                                        if (proyectos[i]==codSuc) {
                                            encontrada=true
                                            break
                                        }
                                    }
                                    if (!encontrada){
                                        temp1 = codSuc
                                        proyectos.add(codSuc)
                                    }
                                }
                            }

                        } else if (tagname.equals("NroComprobanteCompleto", ignoreCase = true)) {
                            numComp= text.toString()
                        } else if (tagname.equals("SucursalDeposito", ignoreCase = true)) {
                            sucDep= text.toString()
                        } else if (tagname.equals("Empleado", ignoreCase = true)) {
                            empl =text!!.toLowerCase(Locale.getDefault())
                            if (!bPaso2){
                                temp = empl
                                empleado.add("Todos")
                                empleado.add(empl)
                                bPaso2 = true
                            } else{
                                if (temp!=empl){
                                    var encontrado=false
                                    for (i in 1 until empleado.size) {
                                        if (empleado[i]==empl) {
                                            encontrado=true
                                            break
                                        }
                                    }
                                    if (!encontrado){
                                        temp = empl
                                        empleado.add(empl)
                                    }
                                }
                            }
                        } else if (tagname.equals("Motivo", ignoreCase = true)) {
                            motivo = text.toString()
                        } else if (tagname.equals("FechaComprobante", ignoreCase = true)) {
                            val dia=text!!.substring(8,10)
                            val mes=text!!.substring(5,7)
                            val ano=text!!.substring(0,4)
                            fecComp ="$dia/$mes/$ano"
                        } else if (tagname.equals("Total", ignoreCase = true)) {
                            tot = java.lang.Float.parseFloat(text.toString())
                        }
                }
                eventType = parser.next()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return employees
    }
    fun listaEmpresa(): ArrayList <String> {
        var tempEmp=ArrayList<Int>()

        for (i in 0 until proyectos.size) {
            tempEmp.add(proyectos[i].toInt())
        }
        proyectos.clear()
        tempEmp= ordenarMenorEmpresa(tempEmp, tempEmp.size)
        proyectos.add("Todas")
        for (i in 0 until tempEmp.size) {
            if(tempEmp[i].toString().length==1){
                proyectos.add("0"+ tempEmp[i].toString())
            }
            else{
                proyectos.add(tempEmp[i].toString())
            }

        }
        tempEmp.clear()
        return proyectos
    }
    fun listaEmpleado(): ArrayList <String> {

        return empleado
    }
}
fun ordenarMenorEmpresa(listNum: ArrayList<Int>, cant: Int) :ArrayList<Int>{
    var tmp : Int
    for(x in 0 until cant) {
        for(y in 0 until cant) {
            if(listNum[x] < listNum[y]) {
                tmp = listNum[y]
                listNum[y] = listNum[x]
                listNum[x] = tmp
            }
        }
    }
    return listNum
}
fun verificaLargo(texto: String): String{
    when(texto.length==1){
        true-> return "0${texto}"
        false-> return texto
    }
}
