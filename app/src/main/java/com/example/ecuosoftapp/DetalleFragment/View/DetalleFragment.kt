package com.example.ecuosoftapp.DetalleFragment.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.View.MainActivity
import com.example.ecuosoftapp.xml.DetalleComp
import com.example.ecuosoftapp.xml.ParserHandlerDetalleComp

class DetalleFragment : Fragment() {

    var sDatos: String?=""
    private lateinit var adetalleComp: ArrayList<DetalleComp>
    private var adapter1:  AdapterDetalleComp? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v=inflater.inflate(R.layout.fragment_detalle, container, false)

        if (activity != null) {
            (activity as MainActivity).title = "Detalle de Comp."
        }
        return v
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (arguments != null)  {
            sDatos=arguments!!.getString("DetalleFragment")
//               MANERJAR CUANDO NO LLEGAN ARGUMENTOS

        }else{
            sDatos="0103NPI : 0001-00001929"

        }

        val lista1: RecyclerView
        val parser = ParserHandlerDetalleComp()
        val istream = context!!.assets.open("Planilla.xml")
        adetalleComp = parser.parseando(istream)
        lista1 = view!!.findViewById(R.id.rcLandingDetalle)
        lista1.layoutManager = LinearLayoutManager(context)
        lista1.itemAnimator = DefaultItemAnimator()
        adapter1 = AdapterDetalleComp(adetalleComp)
        lista1.adapter = adapter1
        adapter1!!.filter.filter(sDatos)


//        bottomNavigationDetalle.setOnNavigationItemSelectedListener { item ->
//            activity!!.vibrate(50)
//            if (item.itemId == R.id.btnBack) {
//                activity?.supportFragmentManager!!.beginTransaction()
//                    .replace(R.id.frlayout, CompFragment())
//                    .addToBackStack(null)
//                    .commit()
//
//            }
//            true
//        }

    }
}
