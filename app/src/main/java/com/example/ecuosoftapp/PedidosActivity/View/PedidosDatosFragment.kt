package com.example.ecuosoftapp.PedidosActivity.View

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.text.format.DateFormat
import java.util.*
import android.text.format.Time.getCurrentTimezone
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.R
import kotlinx.android.synthetic.main.fragment_pedidos_datos.*
import java.sql.Time
import java.time.LocalDateTime


class PedidosDatosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v=inflater.inflate(com.example.ecuosoftapp.R.layout.fragment_pedidos_datos, container, false)

        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val currentTimestamp = "14/10/2019 22:34"//System.currentTimeMillis()
//            editText.setText(currentTimestamp)
//val arrayPrioridad= ArrayAdapter(activity!!, android.R.layout.simple_spinner_item, R.string.prioridad)
            //tvtime.text=currentTimestamp.toString()
        }
//        val date = Date()
//////
//////        val monthDay = (Calendar.DAY_OF_MONTH)
//////        val month = (Calendar.MONTH)
//////        val hora= date.time

        //val myString = DateFormat.getDateInstance().format myDate)

        //DateInstance(DateFormat.is24HourFormat(activity), Locale.UNICODE_LOCALE_EXTENSION)


//        val calendarNow = GregorianCalendar(TimeZone.getTimeZone("Europe/Madrid"))
//        val monthDay = calendarNow.get(Calendar.DAY_OF_MONTH)
//        val month = calendarNow.get(Calendar.MONTH)

//        val d = Date()
//        val hora = DateFormat.format("HH:mm:ss", d.time)
//        val dia = DateFormat.format("yyyy/MM/dd", d.date)
        //val dateInString = date.toString("yyyy/MM/dd HH:mm:ss")
    }

}
