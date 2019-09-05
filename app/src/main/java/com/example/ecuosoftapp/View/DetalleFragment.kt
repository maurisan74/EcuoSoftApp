package com.example.ecuosoftapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.rview.AdapterDetalleComp
import com.example.ecuosoftapp.xml.DetalleComp
import com.example.ecuosoftapp.xml.ParserHandlerDetalleComp
import kotlinx.android.synthetic.main.fragment_detalle.*

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
            sDatos=arguments!!.getString("detalleComp")
//                getArguments()!!.getString("detalleComp")
        }

        val lista1: RecyclerView
        val parser = ParserHandlerDetalleComp()
        val istream = context!!.assets.open("Planilla.xml")
        adetalleComp = parser.parseando(istream)
        lista1 = view!!.findViewById(R.id.rcLandingDetalle)
        lista1.layoutManager = LinearLayoutManager(context)
        lista1.itemAnimator = DefaultItemAnimator()
        adapter1 =  AdapterDetalleComp(adetalleComp)
        lista1.adapter = adapter1
        adapter1!!.filter.filter(sDatos)

        btnBack.setOnClickListener {
            activity?.supportFragmentManager!!.beginTransaction()
                .replace(R.id.frlayout, CompFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
