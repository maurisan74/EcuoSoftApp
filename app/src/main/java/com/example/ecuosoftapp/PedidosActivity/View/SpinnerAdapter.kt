package com.example.ecuosoftapp.PedidosActivity.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.ecuosoftapp.PedidosActivity.PojosRetrofit.ResponseClientes
import com.example.ecuosoftapp.R

class SpinnerAdapter internal constructor(internal var context: Context, internal var list: List<ResponseClientes>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        if (view == null) {
            val inflater = LayoutInflater.from(context)

            view = inflater.inflate(R.layout.item_spinner, viewGroup, false)
        }

        val textView = view!!.findViewById<TextView>(R.id.textView)

        textView.text = list[i].nombre

        return textView

    }
}