package com.example.ecuosoftapp

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.app.ActivityCompat
import com.example.ecuosoftapp.View.MainActivity
import com.muddzdev.styleabletoast.StyleableToast

fun Context.Msje(mensaje: String)=
    StyleableToast.makeText(this,mensaje, R.style.GoodTaoast).show()

public fun Context.vibrate(msg:Long){
    val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    // Check whether device/hardware has a vibrator
    val canVibrate:Boolean = vibrator.hasVibrator()

    if(canVibrate){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // void vibrate (VibrationEffect vibe)
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    msg,
                    // The default vibration strength of the device.
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        }else{
            // This method was deprecated in API level 26
            vibrator.vibrate(msg)
        }
    }
}


//fun Context.solicitar_Runtime_Permission(){
//     val VIBRATOR_PERMISSION_REQUEST_CODE=0
//    if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.VIBRATE)!=PackageManager.PERMISSION_GRANTED){
//        ActivityCompat.requestPermissions(context!!,
//            arrayOf(android.Manifest.permission.VIBRATE),VIBRATOR_PERMISSION_REQUEST_CODE)
//    }
//}