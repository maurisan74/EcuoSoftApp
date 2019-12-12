package com.example.ecuosoftapp.SearchFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import com.example.ecuosoftapp.vibrate
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.ecuosoftapp.CompFragment.View.CompFragment
import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.View.MainActivity
import com.example.ecuosoftapp.addFragment
import kotlinx.android.synthetic.main.fragment_serch.*

class SerchFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
                    }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_serch, container, false)
        if (activity != null) (activity as MainActivity).title = "Filtro de Comprobantes"

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fragment = CompFragment()
        var sSeleccion=""
        val array: MutableList<String>
        var sEmpleado=""
        var sEmpresa=""
        var bEmpleadoTodos=false
        var bEmpresaTodos=false



        array=getArguments()!!.getStringArrayList("key")!!.toMutableList()
        val spArreglo = ArrayAdapter(activity!!, android.R.layout.simple_spinner_item, array)
        spArreglo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spEmpresa!!.setAdapter(spArreglo)
        spEmpresa.setSelection(0)
        spEmpresa?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item = spArreglo.getItem(position)
                sSeleccion=item.toString().trim()
            }
        }


        val param2 = getArguments()!!.getStringArrayList("key2")
            for (i in 0 until param2!!.size) {
                val radioButton2 = RadioButton(context)
                radioButton2.text = param2[i]
                radioButton2.textSize = 18F
                radioButton2.id = i
                val layoutParams2 =
                    RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT)
                radioGroup2.addView(radioButton2, layoutParams2)
        }
        (radioGroup2.getChildAt(0) as RadioButton).isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            activity!!.vibrate(50)
            if (item.itemId == R.id.btnFilter) {

                val parametro = Bundle()
                if (sSeleccion=="Todas"){
                    bEmpresaTodos=true
                }else{sEmpresa = sSeleccion}

                val id: Int =radioGroup2.checkedRadioButtonId
                if (id!=-1){
                    if (id==0){
                        bEmpleadoTodos=true
                    }
                    if (id>0){
                        val radio2:RadioButton = view!!.findViewById(id)
                        sEmpleado=radio2.text.toString()
                    }
                }
                var temp=""
                if (bEmpresaTodos && bEmpleadoTodos) {
                    temp = "0000"
                }
                if (!bEmpresaTodos && bEmpleadoTodos){
                    temp="${sEmpresa}00"
                }
                if (bEmpresaTodos && !bEmpleadoTodos) {
                    temp = "00$sEmpleado"
                }
                if (!bEmpresaTodos &&!bEmpleadoTodos) {
                    temp = "$sEmpresa$sEmpleado"
                }
                parametro.putString("filtro", temp)
                fragment.arguments = parametro
                val ft = fragmentManager!!.beginTransaction()
                ft.replace(R.id.frlayout, fragment, "tag")
                ft.addToBackStack("tag")
                ft.commit()
            }
            if (item.itemId == R.id.btnCancel) {
                addFragment( activity!!.supportFragmentManager,
                    CompFragment(), false, "null",2)


//                activity?.supportFragmentManager!!.beginTransaction()
//                .replace(R.id.frlayout, CompFragment())
//                .addToBackStack(null)
//                .commit()
            }
            true
        }
    }

}
public class Clientes {

    var CodigoPersona: Long = 0
    var Nombre: String? = null

    override fun toString(): String {
        return "User [CodigoPersona=$CodigoPersona, Nombre=$Nombre]"
    }
}