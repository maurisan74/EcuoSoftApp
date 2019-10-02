package com.example.ecuosoftapp.PedidosActivity.View

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return PedidosArchivoFragment()
            1-> return PedidosDetalleFragment()
            else -> return PedidosArchivoFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0-> return "Datos del Pedido"
            1-> return "Detalle del trabajo"
            2-> return "Archivos"
            else -> return null
        }
    }
}