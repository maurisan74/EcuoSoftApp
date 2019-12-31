package com.example.ecuosoftapp.PedidosActivity.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.ecuosoftapp.PedidosActivity.IO.ResponseClientes
import com.example.ecuosoftapp.PedidosActivity.IO.ResponseTiposTrabajos
import com.example.ecuosoftapp.R

class SpinnerAdapterClientes internal constructor(internal var context: Context, internal var list: List<ResponseClientes>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view1: View?, viewGroup: ViewGroup): View {
       var views=view1
        if (views == null) {
            val inflater = LayoutInflater.from(context)

            views = inflater.inflate(R.layout.item_spinner, viewGroup, false)
        }

        val textView = views!!.findViewById<TextView>(R.id.textView)
        textView.text = list[i].nombre
        return textView

    }
}


class SpinnerAdapterTrabajos internal constructor(internal var context: Context, internal var list: List<ResponseTiposTrabajos>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view2: View?, viewGroup: ViewGroup): View {
        var view=view2
        if (view == null) {
            val inflater = LayoutInflater.from(context)

            view = inflater.inflate(R.layout.item_spinner, viewGroup, false)
        }

        val textView = view!!.findViewById<TextView>(R.id.textView)
        textView.text = list[i].detalleTrabajo
        return textView

    }
}