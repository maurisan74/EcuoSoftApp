package com.example.ecuosoftapp.DetalleFragment.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecuosoftapp.DetalleFragment.xml.DetalleComp
import com.example.ecuosoftapp.R
import kotlinx.android.synthetic.main.item_detalle_comp.view.*
import kotlin.collections.ArrayList

class AdapterDetalleComp(private val itemDetalleComp: ArrayList<DetalleComp>) : RecyclerView.Adapter<AdapterDetalleComp.ViewHolder1>(), Filterable {

    internal var items2 : ArrayList<DetalleComp>?=null

    init {
        this.items2=itemDetalleComp
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        val itemDetalleComp=items2?.get(position)

        holder.codigoEmpresa!!.text=itemDetalleComp!!.CodigoEmpresa
        holder.codigoSucursal!!.text=itemDetalleComp.CodigoSucursal
        holder.nroSerieComprobante!!.text=itemDetalleComp.NroSerieComprobante
        holder.numeroComprobante!!.text=itemDetalleComp.NumeroComprobante
        holder.codigoArticuloServicio!!.text=itemDetalleComp.CodigoArticuloServicio
        holder.tipo!!.text=itemDetalleComp.Tipo
        holder.rubro!!.text=itemDetalleComp.Rubro
        holder.articuloServicio!!.text=itemDetalleComp.ArticuloServicio
        holder.cantidad!!.text=itemDetalleComp.Cantidad
        holder.unidadMedida!!.text=itemDetalleComp.UnidadMedida
        holder.totalLineaDescuento!!.text=itemDetalleComp.TotalLineaDescuento
        holder.observacion!!.text=itemDetalleComp.Observacion
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {

        val vista  = LayoutInflater.from(parent.context).inflate(R.layout.item_detalle_comp, parent, false)
        return ViewHolder1(vista)
    }

    override fun getItemCount(): Int {
            return items2!!.count()
    }

    class ViewHolder1(vista1: View) : RecyclerView.ViewHolder(vista1){

        var codigoEmpresa: TextView?=null
        var codigoSucursal: TextView?=null
        var nroSerieComprobante: TextView?=null
        var numeroComprobante: TextView?=null
        var codigoArticuloServicio: TextView?=null
        var tipo: TextView?=null
        var rubro: TextView?=null
        var articuloServicio: TextView?=null
        var cantidad: TextView?=null
        var unidadMedida: TextView?=null
        var valorUnitarioDescuento: TextView?=null
        var totalLineaDescuento: TextView?=null
        var observacion: TextView?=null

        init {
            codigoEmpresa=vista1.textView15
            codigoSucursal=vista1.textView15
            nroSerieComprobante=vista1.textView15
            numeroComprobante=vista1.textView15
            codigoArticuloServicio=vista1.tvCodigo
            tipo=vista1.tvTipo
            rubro=vista1.tvtime
            articuloServicio=vista1.tvDescArt
            cantidad=vista1.tvCant
            unidadMedida=vista1.tvUniMedida
            valorUnitarioDescuento=vista1.tvCosto
            totalLineaDescuento=vista1.tvTotal
            observacion=vista1.tvObservaciones

//            vista.setOnClickListener {
//                if (listener != null) {
//                    val position = adapterPosition
//                    if (position != RecyclerView.NO_POSITION) {
//                        listener.onItemClick(position)
//                    }
//                }
//            }
//            vista.setOnLongClickListener {
//                if (listener != null) {
//                    val position = adapterPosition
//                    if (position != RecyclerView.NO_POSITION) {
//                        listener.onLongClick(position)
//                    }
//                }
//                return@setOnLongClickListener true
//            }
        }
    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
                items2 = filterResults?.values as ArrayList<DetalleComp>
                notifyDataSetChanged()
            }

            override fun performFiltering(charSequence: CharSequence): FilterResults {

                val charString = charSequence.toString()
                val charString1: CharSequence
                val charString2: CharSequence
                val charString3 : CharSequence
                val charString4: CharSequence

                val iEmpTemp=charString.subSequence(0,2).toString().trim().toInt()//empresa
                val iSucTemp=charString.subSequence(2,4).toString().trim().toInt()//sucursal de la empresa
                val iSucNTemp=charString.subSequence(11,15).toString().trim().toInt()//sucursal del numero
                val iNumTemp=charString.subSequence(16, charString.length).toString().trim().toInt()//numero comp

                 charString1=iEmpTemp.toString().trim()
                 charString2=iSucTemp.toString().trim()
                 charString3=iSucNTemp.toString().trim()
                 charString4=iNumTemp.toString().trim()

                var temp: String
                var temp1: String
                var temp2: String
                var temp3: String
                var temp4: String

                if (charString.isEmpty()) {
                    items2 = itemDetalleComp
                } else {
                    val filteredList1 = ArrayList<DetalleComp>()
                    for (row in itemDetalleComp) {
                        if (row.CodigoEmpresa.contains(charString1)&& row.CodigoSucursal.contains(charString2)&& row.NroSerieComprobante.contains(charString3)&& row.NumeroComprobante.contains(charString4)) {
                            temp1 = row.CodigoEmpresa
                            temp2 = row.CodigoSucursal
                            temp3 = row.NroSerieComprobante
                            temp4 = row.CodigoArticuloServicio
                            temp = row.NumeroComprobante
                            filteredList1.add(row)
                        }
                    }
                    items2=filteredList1
                }
                val filterResults = FilterResults()
                filterResults.values=items2
                return filterResults
            }
        }
    }
}