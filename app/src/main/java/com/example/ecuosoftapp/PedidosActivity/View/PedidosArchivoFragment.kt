package com.example.ecuosoftapp.PedidosActivity.View


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.ecuosoftapp.R

/**
 * A simple [Fragment] subclass.
 */
class PedidosArchivoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedidos_archivo, container, false)
    }


}
