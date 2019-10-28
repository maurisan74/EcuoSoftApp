package com.example.ecuosoftapp.PedidosActivity.View


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.View.MainActivity
import com.google.android.material.tabs.TabLayout

class TabFragment : Fragment() {

    companion object {
        lateinit var tabLayout: TabLayout
        lateinit var viewPager: ViewPager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_tab, container, false)
        if (activity != null) {
            (activity as MainActivity).title = "Pedidos de Trabajos"
        }
        tabLayout=v.findViewById(R.id.tabs) as TabLayout
        viewPager=v.findViewById(R.id.viewpager) as ViewPager
        viewPager.adapter=MyPagerAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }
        return v
    }

    internal inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return PedidosDatosFragment()
                1 -> return PedidosDetalleFragment()
                else -> return PedidosDetalleFragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }
        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0-> return "Datos del Pedido"
                1-> return "Detalle del trabajo"
                else -> return null
            }
        }
    }

}
