package com.example.ecuosoftapp.View

import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecuosoftapp.Msje
import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.rview.AdapterLanding
import com.example.ecuosoftapp.vibrate
import com.example.ecuosoftapp.xml.Comprobante
import com.example.ecuosoftapp.xml.ParserHandlerComp
import kotlinx.android.synthetic.main.fragment_comp.*

class CompFragment : Fragment() {

    private lateinit var comprobantes: ArrayList<Comprobante>
    private var adapter: AdapterLanding? = null

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

        //XmlPullParserHandler()

        //Esta forma de usar el assets es por que esta en un fragment

//            suspend fun carga(): IntArray
//            {
                val lista: RecyclerView
                val parser = ParserHandlerComp()
                val istream = context!!.assets.open("Planilla.xml")
                comprobantes = parser.parse(istream)
                lista = view!!.findViewById(R.id.rcLanding)
                lista?.layoutManager = LinearLayoutManager(context)
                lista.itemAnimator = DefaultItemAnimator()
                adapter = AdapterLanding(comprobantes)
                lista?.adapter = adapter
//                return IntArray(lista.getAdapter()!!.getItemCount())
//            }



        val listEmp = ParserHandlerComp().listaEmpresa()
        val listEmple = ParserHandlerComp().listaEmpleado()

        if (arguments != null)  {
            adapter!!.filter.filter(getArguments()!!.getString("filtro"))
        }
        val listNum = IntArray(lista.getAdapter()!!.getItemCount())
        fun changeItem(position: Int) {
            when (listNum[position]) {
                0 -> {
                    adapter?.items2!![position].imagen = R.drawable.ic_done_green
                    listNum[position] = 2
                }
                2 -> {
                    adapter?.items2!![position].imagen = R.drawable.ic_close_red
                    listNum[position] = 1
                }
                1 -> {
                    adapter?.items2!![position].imagen = R.drawable.ic_noimage
                    listNum[position] = 0
                }
            }
            adapter?.notifyItemChanged(position)
        }

        fun DetalleComp(position: Int) {
            val sCodEmp=adapter?.items2!![position].codigoEmpresa
            val sCodSuc=adapter?.items2!![position].codigoSucursal
            val sNumComp=adapter?.items2!![position].numeroComprobante

            val fragment = DetalleFragment()
            val parametro = Bundle()
            parametro.putString("detalleComp", sCodEmp+sCodSuc+sNumComp)
            fragment.arguments = parametro
            val ft = fragmentManager!!.beginTransaction()
            ft.replace(R.id.frlayout, fragment, "tag")
            ft.addToBackStack("tag")
            ft.commit()
        }

        adapter?.setOnItemClickListener(object : AdapterLanding.OnItemClickListener {
            override fun onItemClick(position: Int) {
                changeItem(position)
            }

            override fun onLongClick(position: Int) {
                DetalleComp(position)
            }
        })
        bottomNavigationComp.setOnNavigationItemSelectedListener { item ->
                   activity!!.vibrate(50)
           when (item.itemId){

               R.id.btnFilter->{
                   val fragment = SerchFragment()
                   val parametro = Bundle()
                   parametro.putStringArrayList("key", listEmp)
                   parametro.putStringArrayList("key2", listEmple)
                   fragment.arguments = parametro
                   val ft = fragmentManager!!.beginTransaction()
                   ft.replace(R.id.frlayout, fragment, "tag")
                   ft.addToBackStack("tag")
                   ft.commit()
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
                               adapter?.items2!![i].imagen = R.drawable.ic_noimage
                               adapter?.notifyItemChanged(i)
                           }
                       }).create().show()
               }

               R.id.btnBack->{
                   activity?.supportFragmentManager!!.beginTransaction()
                       .replace(R.id.frlayout, HomeFragment())
                       .addToBackStack(null)
                       .commit()
               }
           }
            true
        }
    }
}