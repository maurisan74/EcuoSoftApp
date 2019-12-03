package com.example.ecuosoftapp.PedidosActivity.Models
import androidx.annotation.Keep
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class TiposdeTrabajos (   @Expose(deserialize = false)
                               @SerializedName("CodigoObjeto")
                               var codigoObjetoSA: String, // 15000

                               @Expose(deserialize = false)
                               @SerializedName("Codigo")
                               var codigoTipoTrabajo: String, // 1
                               @Expose(deserialize = true)
                               @SerializedName("Detall")
                               var detalleTrabajo: String // Mantenimiento)
)