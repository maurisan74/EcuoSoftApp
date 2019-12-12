package com.example.ecuosoftapp.CompFragment.View

import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecuosoftapp.*
import com.example.ecuosoftapp.CompFragment.Interactors.CompPresenter
import com.example.ecuosoftapp.CompFragment.Interactors.CompView
import com.example.ecuosoftapp.CompFragment.Presenter.CompPresenterImpl
import com.example.ecuosoftapp.DetalleFragment.View.DetalleFragment
import com.example.ecuosoftapp.View.MainActivity
import com.example.ecuosoftapp.SearchFragment.SerchFragment
import com.example.ecuosoftapp.CompFragment.xml.Comprobante
import kotlinx.android.synthetic.main.fragment_comp.*

class CompFragment : CompView, Fragment() {

    private var adapter: AdapterLanding? = null
    private lateinit var lista: RecyclerView
    private lateinit var presentador: CompPresenter
    private lateinit var sListaEmpleados: ArrayList<String>
    private lateinit var sListaEmpresas: ArrayList<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_comp, container, false)
//        val interpolator = OvershootInterpolator()
//        var isOpenMenu = false
//        val traslationY = 100f
//        val fabFabMain: FloatingActionButton = v.findViewById(R.id.btnFabMain)
//        val fabSend: FloatingActionButton = v.findViewById(R.id.btnCancel)
//        val fabSerch: FloatingActionButton = v.findViewById(R.id.btnFilter)
//        fabSend.alpha = 0f
//        fabSerch.alpha = 0f
//        fabSend.translationY = traslationY
//        fabSerch.translationY = traslationY


        if (activity != null) {
            (activity as MainActivity).title = "Autorización de comprobantes"
        }


//        if ((activity as MainActivity).supportActionBar != null) {
//            val actionBar = (activity as MainActivity).supportActionBar
//            //actionBar!!.hide()
//            //actionBar.setDisplayHomeAsUpEnabled(true)
//            //actionBar!!.addOnMenuVisibilityListener { menu.i}
////            actionBar!!.setDisplayHomeAsUpEnabled(false)
////            actionBar.setHomeButtonEnabled(false)
//        }


//        fabFabMain.setOnClickListener {
//            if (isOpenMenu) {
//                isOpenMenu = !isOpenMenu
//                fabFabMain.animate().setInterpolator(interpolator).rotationBy(0f).setDuration(300).start()
//                fabSend.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//                fabSerch.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//            } else {
//                isOpenMenu = !isOpenMenu
//                fabFabMain.animate().setInterpolator(interpolator).rotationBy(45f).setDuration(300).start()
//                fabSend.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//                fabSerch.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//            }
//            fun openMenu() {
//                isOpenMenu = !isOpenMenu
//                fabFabMain.animate().setInterpolator(interpolator).rotationBy(45f).setDuration(300).start()
//                fabSend.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//                fabSerch.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//            }
//
//            fun closeMenu() {
//                isOpenMenu = !isOpenMenu
//                fabFabMain.animate().setInterpolator(interpolator).rotationBy(0f).setDuration(300).start()
//                fabSend.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//                fabSerch.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//            }
//        }
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presentador= CompPresenterImpl(this)
        presentador.BuscarDatosPresenter(context!!)
        arguments?.let {adapter!!.filter.filter(arguments!!.getString("filtro")) }

        val listNum = IntArray(lista.adapter!!.itemCount)
        fun changeItem(position: Int) {
            when (listNum[position]) {
                0 -> {
                    adapter?.items2!![position].imagen = R.drawable.ic_done_green
                    listNum[position] = 2 }
                2 -> {
                    adapter?.items2!![position].imagen = R.drawable.ic_close_red
                    listNum[position] = 1 }
                1 -> {
                    adapter?.items2!![position].imagen = R.drawable.ic_noimage
                    listNum[position] = 0 }
            }
            adapter?.notifyItemChanged(position)
        }

        fun DetalleComp(position: Int) {
            adapter?.let {adapter ->
                val empresa=adapter.items2!![position].codigoEmpresa
                val sucursal=adapter.items2!![position].codigoSucursal
                val numero=adapter.items2!![position].numeroComprobante
                addFragment(activity!!.supportFragmentManager,
                    DetalleFragment(), true, "DetalleFragment",3,
                    CompFragment(),
                    empresa+sucursal+numero)
            }

        }

        adapter?.setOnItemClickListener(object : AdapterLanding.OnItemClickListener {
            override fun onItemClick(position: Int) {
                changeItem(position)
            }

            override fun onLongClick(position: Int) {
                DetalleComp(position)
            }
        })
        bNavigationPTD.setOnNavigationItemSelectedListener { item ->
                   activity!!.vibrate(50)
           when (item.itemId){

               R.id.btnFilter->{
                   addFragmentArgArray(activity!!.supportFragmentManager,
                       SerchFragment(), false, "SerchFragment",1,
                       CompFragment(),
                       sListaEmpresas,sListaEmpleados,"key","key2" )

                  // val fragment = SerchFragment()
                  // val parametro = Bundle()
                   //parametro.putStringArrayList("key", sListaEmpresas)
                 //  parametro.putStringArrayList("key2", sListaEmpleados)
//                   fragment.arguments = parametro
//                   val ft = fragmentManager!!.beginTransaction()
//                   ft.replace(R.id.frlayout, fragment, "tag")
//                   ft.addToBackStack("tag")
//                   ft.commit()
               }

               R.id.btnSend->{
                   var cantApro = 0
                   var cantRecha = 0
                   for (i in 0..listNum.size - 1) {
                       if (listNum[i] == 2) {
                           ++cantApro
                       }
                       if (listNum[i] == 1) {
                           ++cantRecha
                       }
                   }
                   AlertDialog.Builder(activity!!)
                       .setCancelable(false)
                       //.setTitle("Alert Dialog")
                       .setMessage("¿Confirma que Aprueba $cantApro comprobantes y Rechaza $cantRecha comprobantes?")
                       .setIcon(android.R.drawable.ic_dialog_alert)
                       .setPositiveButton("SI", DialogInterface.OnClickListener
                       { dialog, which ->
                           activity!!.Msje("Enviando Comp...")
//                        Toast.makeText(activity, "Enviando Comp...", Toast.LENGTH_SHORT).show()
                       })
                       .setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which ->
                           activity!!.Msje("Cancelado")
                           //                        Toast.makeText(activity, "Cancelado", Toast.LENGTH_SHORT).show()
                           for (i in 0..listNum.size - 1) {
                               listNum[i] = 0
                               adapter?.items2!![i].imagen = R.drawable.ic_noimage1
                               adapter?.notifyItemChanged(i)
                           }
                       }).create().show()
               }
               R.id.btnBack->{
                   activity?.onBackPressed()
//                   activity?.supportFragmentManager!!.beginTransaction()
//                       .replace(R.id.frlayout, HomeFragment())
//                       .addToBackStack(null)
//                       .commit()
               }
           }
            true
        }
    }
    override fun ShowProgressBar(mostrar: Boolean)  { if(mostrar) progress.visibility=View.VISIBLE else progress.visibility=View.GONE }
    override fun ShowRecyclerView(mostrar: Boolean) { if(mostrar) rcLanding.visibility=View.VISIBLE else rcLanding.visibility=View.GONE }

    override fun LoadDatosRecyclerView(comprobantes: ArrayList<Comprobante>) {
        lista = view!!.findViewById(R.id.rcLanding)
        lista.layoutManager = LinearLayoutManager(context)
        lista.itemAnimator = DefaultItemAnimator()
        adapter = AdapterLanding(comprobantes)
        lista.adapter = adapter
    }
    override fun ShowError(mensaje: String) {activity!!.Msje(mensaje)}
    override fun ListaEmpleados(listEmple: ArrayList<String>) {sListaEmpleados=listEmple }
    override fun ListaEmpresas(listEmp: ArrayList<String>) {sListaEmpresas=listEmp }
}