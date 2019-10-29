package com.example.ecuosoftapp.PedidosActivity.View


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.View.MainActivity

/**
 * A simple [Fragment] subclass.
 */
class ConformidadFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (activity != null) {
            (activity as MainActivity).title = "Conformidad a Ordenes de Trabajo"
        }
        return inflater.inflate(R.layout.fragment_conformidad, container, false)
    }


}
