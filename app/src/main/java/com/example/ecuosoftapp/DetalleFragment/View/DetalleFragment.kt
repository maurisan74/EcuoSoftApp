package com.example.ecuosoftapp.DetalleFragment.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecuosoftapp.DetalleFragment.Interfaces.DetallePresenter
import com.example.ecuosoftapp.DetalleFragment.Interfaces.DetalleView
import com.example.ecuosoftapp.DetalleFragment.Presenter.DetallePresenterImpl
import com.example.ecuosoftapp.DetalleFragment.xml.DetalleComp
import com.example.ecuosoftapp.Msje
import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.View.MainActivity
import kotlinx.android.synthetic.main.fragment_detalle.*
import kotlinx.android.synthetic.main.fragment_detalle.progress

class DetalleFragment : DetalleView, Fragment() {


    private lateinit var presentador: DetallePresenter

    private var adapter1:  AdapterDetalleComp? = null
    private var sDatos: String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentador= DetallePresenterImpl(this)
        arguments?.let {
            sDatos=arguments!!.getString("DetalleFragment")

        }
    }

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

    override fun ShowdatosRecyclerView(adetalleComp: ArrayList<DetalleComp>) {
        val lista1: RecyclerView

        lista1 = view!!.findViewById(R.id.rcLandingDetalle)
        lista1.layoutManager = LinearLayoutManager(context)
        lista1.itemAnimator = DefaultItemAnimator()
        adapter1 = AdapterDetalleComp(adetalleComp)
        lista1.adapter = adapter1
        adapter1!!.filter.filter(sDatos)
    }

    override fun ShowError(mensaje: String) {activity!!.Msje(mensaje)}
    override fun ShowRecyclerView(mostrar: Boolean)  { if(mostrar) rcLandingDetalle.visibility=View.VISIBLE else rcLandingDetalle.visibility=View.GONE }
    override fun ShowProgressBar(mostrar: Boolean) { if(mostrar) progress.visibility=View.VISIBLE else progress.visibility=View.GONE }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presentador.BuscarDatosPresenter(context!!)
    }
}
