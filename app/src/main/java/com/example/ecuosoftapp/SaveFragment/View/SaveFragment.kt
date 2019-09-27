package com.example.ecuosoftapp.SaveFragment.View

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
        presentador= SavePresenterImpl(this)
        presentador.SolicitaServersPresenter()
    }

    override fun showErrorServidor(error: String) {
        tvServer.error=error
        tvServer.requestFocus()
        tvServer.hint=error
    }
    override fun LoadServers(servers: Array<String>) {servidores= servers}
    override fun LoadUser(server: String, user: String, password: String, default: Boolean) {
        servidor=server
        usuario=user
        clave=password
        predeterminado=default
    }
    override fun showMesage(message: String) {activity!!.Msje(message)}
    override fun showErrorUsuario(error: String) {
        etUsuario.error=error
        etUsuario.requestFocus()
        etUsuario.hint=error
    }

    override fun showErrorClave(error: String) {
        tvClave.error=error
        tvClave.requestFocus()
        tvClave.hint=error
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
        var serverSel=0

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

                presentador.guardaDatosPresenter(
                    tvServer.text.toString(),
                    etUsuario.text.toString(),
                    tvClave.text.toString(),
                    cPredeterminado.isChecked,
                    context!!,serverSel
                )
            }
            true
        }
    }
}
//
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

