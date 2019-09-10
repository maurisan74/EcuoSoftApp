package com.example.ecuosoftapp

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import com.example.ecuosoftapp.View.MainActivity
import com.muddzdev.styleabletoast.StyleableToast
import java.util.jar.Attributes
import kotlin.math.max
import kotlin.math.min

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
//
//class BottonNavigationComportamiento(context: Context, attrs: AttributeSet): CoordinatorLayout.Behavior<View>(context,attrs)
//{
//    //Ctrl+o
//    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout,child: View,directTargetChild: View,target: View,axes: Int,type: Int): Boolean {
//        return axes==ViewCompat.SCROLL_AXIS_VERTICAL
//    }
//
//    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
//        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
//        child.translationY= max(0f, min(child.height.toFloat(),child.translationY+dyConsumed))
//    }
//
//
//}
//fun Context.solicitar_Runtime_Permission(){
//     val VIBRATOR_PERMISSION_REQUEST_CODE=0
//    if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.VIBRATE)!=PackageManager.PERMISSION_GRANTED){
//        ActivityCompat.requestPermissions(context!!,
//            arrayOf(android.Manifest.permission.VIBRATE),VIBRATOR_PERMISSION_REQUEST_CODE)
//    }
//}