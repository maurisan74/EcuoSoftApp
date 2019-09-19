package com.example.ecuosoftapp.SaveFragment.View

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.ecuosoftapp.*
import com.example.ecuosoftapp.SaveFragment.Interfaces.SavePresenter
import com.example.ecuosoftapp.SaveFragment.Interfaces.SaveView
import com.example.ecuosoftapp.SaveFragment.Presenter.SavePresenterImpl
import com.example.ecuosoftapp.View.MainActivity
import kotlinx.android.synthetic.main.fragment_save.*

class SaveFragment : SaveView,Fragment() {

    lateinit var presentador: SavePresenter
    lateinit var servidores: Array<String>
    lateinit var servidor: String
    lateinit var usuario: String
    lateinit var clave: String
    var predeterminado: Boolean=false
    private var datoCargado=""
    private var serverSel=0

    override fun LoadServers(servers: Array<String>) {servidores= servers}
    override fun LoadUser(server: String, user: String, password: String, default: Boolean) {
        servidor=server
        usuario=user
        clave=password
        predeterminado=default
    }
    override fun showMesage(message: String) {activity!!.Msje(message)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        presentador= SavePresenterImpl(this)
        presentador.SolicitaServersPresenter()
    }
    override fun showErrorDatos(error: String) {
        //.
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val interpolator = OvershootInterpolator()
//        var isOpenMenu = false
//        val traslationY = 100f

        val v = inflater.inflate(R.layout.fragment_save, container, false)
//        val fabFabMain: FloatingActionButton = v.findViewById(R.id.btnFabMain)
//        val fabBack: FloatingActionButton = v.findViewById(R.id.btnBack)
//        val fabDelete: FloatingActionButton = v.findViewById(R.id.btnDelete)
//        val fabSave: FloatingActionButton = v.findViewById(R.id.btnSave)
//        fabBack.alpha=0f
//        fabSave.alpha=0f
//        fabDelete.alpha=0f
//        fabBack.translationY=traslationY
//        fabSave.translationY=traslationY
//        fabDelete.translationY=traslationY



        if (activity != null) {
            (activity as MainActivity).title = "Configuración"
        }
//        if ((activity as MainActivity).supportActionBar != null) {
//            val actionBar = (activity as MainActivity).supportActionBar
//            actionBar!!.setDisplayHomeAsUpEnabled(true)
//            with(actionBar) {
//                setDisplayHomeAsUpEnabled(true)
//                setHomeButtonEnabled(true)
//
//            }
//        }
//        fabFabMain.setOnClickListener {
//            if (isOpenMenu){
//                isOpenMenu=!isOpenMenu
//                fabFabMain.animate().setInterpolator(interpolator).rotationBy(0f).setDuration(300).start()
//                fabBack.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//                fabSave.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//                fabDelete.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//
//            }else{
//                isOpenMenu=!isOpenMenu
//                fabFabMain.animate().setInterpolator(interpolator).rotationBy(45f).setDuration(300).start()
//                fabBack.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//                fabSave.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//                fabDelete.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//            }
//            fun openMenu(){
//                isOpenMenu=!isOpenMenu
//                fabFabMain.animate().setInterpolator(interpolator).rotationBy(45f).setDuration(300).start()
//                fabBack.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//                fabSave.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//                fabDelete.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
//            }
//
//            fun closeMenu(){
//                isOpenMenu=!isOpenMenu
//                fabFabMain.animate().setInterpolator(interpolator).rotationBy(0f).setDuration(300).start()
//                fabBack.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//                fabSave.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//                fabDelete.animate().translationY(traslationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
//            }
//        }

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        spServers.adapter=ArrayAdapter(activity!!, android.R.layout.simple_list_item_1,servidores)
        spServers.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) { }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, i: Int, d: Long) {
                presentador.GetUserPresenter(i,activity!!)
                etUsuario.text!!.clear()
                tvClave.text!!.clear()
                tvServer.text!!.clear()
                cPredeterminado.isChecked=false
                tvServer.text!!.insert(0,servidor)
                etUsuario.text!!.insert(0,usuario)
                tvClave.text!!.insert(0,clave)
                cPredeterminado.isChecked = predeterminado
                serverSel=i
            }
        }
        bottomNavigationSave.setOnNavigationItemSelectedListener { item ->
            activity!!.vibrate(50)
            if (item.itemId == R.id.btnBack) activity?.onBackPressed()
            if (item.itemId == R.id.btnDelete) {
                etUsuario.text!!.clear()
                tvClave.text!!.clear()
                tvServer.text!!.clear()
                cPredeterminado.isChecked=false
                presentador.DeleteServerPresenter(serverSel,activity!!)
            }

            if (item.itemId == R.id.btnSave) {
                val sharedPreferences=context!!.getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                var server=""
                var us=""
                var cl=""
                var usurioOK=false
                var claveOK=false
                var serverOK=false

                if (tvServer.text!!.isEmpty() or tvServer.text!!.isBlank()) {
                    tvServer.error="Server No Valido"
                    tvServer.requestFocus()
                    tvServer.hint="server no válido"
                }else{
                    server=tvServer.text.toString().trim()
                    serverOK=true
                }

                if (etUsuario.text!!.isEmpty() or etUsuario.text!!.isBlank()) {
                    etUsuario.error="Usuario Incorrecto"
                    etUsuario.requestFocus()
                    etUsuario.hint="Usuario Incorrecto"
                }else{
                    us = etUsuario.text.toString().trim()
                    usurioOK=true
                }

                if (tvClave.text!!.isEmpty() or tvClave.text!!.isBlank()) {
                    tvClave.error="Clave Incorrecta"
                    tvClave.requestFocus()
                    tvClave.hint="Clave Incorrecta"
                }else{
                    cl=tvClave.text.toString().trim()
                    claveOK=true
                }


//            val control=activity!!.getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
//            if (control.getString("x", "")=="" && control.getString("y", "")=="" && control.getString("z", "")=="") {
//                AlertDialog.Builder(activity!!)
//                    .setCancelable(false)
//                    //.setTitle("Alert Dialog")
//                    .setMessage("¿Desea que este servidor sea predeterminado?")
//                    //.setIcon(android.R.drawable.ic_dialog_alert)
//                    .setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which ->
//                        datoCargado=""
//                    }).setPositiveButton("SI", DialogInterface.OnClickListener
//                    { dialog, which ->
//                        cPredeterminado.isChecked=true
//                        datoCargado="OK"
//                    }).create().show()
//            }

                if(cPredeterminado.isChecked){
                    datoCargado="OK"
                }else{
                    datoCargado=""
                }
                if (serverOK && usurioOK && claveOK ){
                    when (serverSel) {
                        0 -> {
                            editor?.putString("a", server)
                            editor?.putString("b", us)
                            editor?.putString("c", cl)
                            if (datoCargado=="OK") {
                                editor?.putString("x", datoCargado)
                                editor?.putString("y", "")
                                editor?.putString("z", "")
                            }else editor?.putString("x", "")
                        }
                        1 -> {
                            editor?.putString("d", server)
                            editor?.putString("e", us)
                            editor?.putString("f", cl)
                            if (datoCargado=="OK") {
                            editor?.putString("y", datoCargado)
                            editor?.putString("x", "")
                            editor?.putString("z", "")
                            }else editor?.putString("y", "")
                        }
                        2-> {
                            editor?.putString("g", server)
                            editor?.putString("h", us)
                            editor?.putString("i", cl)
                            if (datoCargado=="OK") {
                            editor?.putString("z", datoCargado)
                            editor?.putString("y", "")
                            editor?.putString("x", "")
                            }else editor?.putString("z", "")
                        }
                    }
                    editor?.apply()
                    editor.commit()
                    context!!.Msje("!Datos Registrados¡")

//                    val bac = object  : Thread(){
//                        override fun run(){
//                            try {
//                                sleep(3500)
//                                activity?.supportFragmentManager?.beginTransaction()
//                                    ?.replace(R.id.fragment, HomeFragment())
//                                    ?.addToBackStack(null)
//                                    ?.commit()
//                                //vuelve atras un fragmento
//                                //activity?.supportFragmentManager?.popBackStack()
//                            } catch (e : Exception){
//                                e.printStackTrace()
//                            }
//                        }
//                    }
//                    bac.start()
                }
            }
            true
        }
    }
}
