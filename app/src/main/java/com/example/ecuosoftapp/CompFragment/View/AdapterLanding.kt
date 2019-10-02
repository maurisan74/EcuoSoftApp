package com.example.ecuosoftapp.CompFragment.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecuosoftapp.R
import com.example.ecuosoftapp.CompFragment.xml.Comprobante
import kotlinx.android.synthetic.main.item.view.*
import kotlin.collections.ArrayList


class AdapterLanding(private val items: ArrayList<Comprobante>) : RecyclerView.Adapter<AdapterLanding.ViewHolder>(), Filterable {

    internal var items2 : ArrayList<Comprobante>?=null
    private var mListener: OnItemClickListener? = null

    init {
        this.items2=items
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onLongClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items2?.get(position)

        holder.codigoEmpresa?.text=item!!.codigoEmpresa
        holder.codigoSucursal?.text=item.codigoSucursal
        holder.numeroComprobante?.text=item.numeroComprobante
        holder.sucursalDeposito!!.text=item.sucursalDeposito
        holder.empleado?.text=item.empleado
        holder.motivo?.text=item.motivo
        holder.fechaComprobante?.text=item.fechaComprobante
        holder.total?.text=item.total.toString()
        holder.imagen?.setImageResource(item.imagen)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val vista  = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(vista, mListener)
    }

    override fun getItemCount(): Int {
        return items2?.count()!!
    }

    class ViewHolder(vista: View, listener: OnItemClickListener?) : RecyclerView.ViewHolder(vista){

        var codigoEmpresa: TextView?=null
        var codigoSucursal: TextView?=null
        var numeroComprobante: TextView?=null
        var sucursalDeposito: TextView?=null
        var empleado: TextView?=null
        var motivo: TextView?=null
        var fechaComprobante: TextView?=null
        var total: TextView?=null
        var imagen: ImageView?=null

        init {
            codigoEmpresa=vista.tvEmpresa
            codigoSucursal=vista.tvcodigoSucursal
            numeroComprobante=vista.tvnumeroComprobante
            sucursalDeposito=vista.tvSucDep
            empleado=vista.tvempleado
            motivo=vista.tvmotivo
            fechaComprobante=vista.tvfechaComprobante
            total=vista.tvtotal
            imagen=vista.ivHolder

            vista.setOnClickListener {
                if (listener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position)
                    }
                }
            }
            vista.setOnLongClickListener {
                if (listener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onLongClick(position)
                    }
                }
                return@setOnLongClickListener true
            }
        }
    }
    override fun getFilter(): Filter {
            return object : Filter() {
                override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
                    items2 = filterResults!!.values as ArrayList<Comprobante>
                    notifyDataSetChanged()
                }

                override fun performFiltering(charSequence: CharSequence): FilterResults {

                    var charString = charSequence.toString()
                    var charString2 = charSequence.toString()

                    val sEmpTemp=charString.subSequence(0,2)
                    val sEmpleTemp=charString.subSequence(2,charString.length)

                    charString=charString.subSequence(2,charString.length).toString()//empleado
                    charString2=charString2.subSequence(0,2).toString()//empresa

                    if (charString.isEmpty() || (sEmpTemp=="00" && sEmpleTemp=="00")) {
                        items2 = items
                    } else {
                        val filteredList = ArrayList<Comprobante>()

                        for (row in items) {
                            if (sEmpTemp!="00" && sEmpleTemp!="00") {
                                if (row.empleado!!.toLowerCase().contains(charString) && row.codigoSucursal.toLowerCase().contains(charString2)) filteredList.add(row)
                            }
                            if (sEmpTemp=="00" && sEmpleTemp!="00"){
                                if (row.empleado!!.toLowerCase().contains(charString)) filteredList.add(row)
                            }
                            if (sEmpTemp!="00" && sEmpleTemp=="00") {
                                if (row.codigoSucursal.toLowerCase().contains(charString2)) filteredList.add(row)
                            }
                        }
                        items2=filteredList
                        }
                    val filterResults = FilterResults()
                    filterResults.values=items2
                    return filterResults
                }
            }
    }
}