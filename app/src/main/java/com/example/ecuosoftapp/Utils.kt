package com.example.ecuosoftapp

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ecuosoftapp.View.HomeFragment
import com.muddzdev.styleabletoast.StyleableToast

fun Context.Msje(mensaje: String)=
    StyleableToast.makeText(this,mensaje, R.style.GoodTaoast).show()

 fun Context.vibrate(msg:Long){
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
fun clearofStackbyName(manager: FragmentManager, name: String) {
    val oneFragment = manager.findFragmentByTag(name)?.id
    val backStackCount =  manager.backStackEntryCount
    for (i in 0 until backStackCount) {
//
//        // Get the back stack fragment id.
//        val backStackName = manager.getBackStackEntryAt(i).name
//n
   // if (oneFragment!= null){
    if (oneFragment != null) {
        manager.popBackStack(oneFragment, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
//
   }
}

 fun clearBackStack(manager: FragmentManager) {

    while (manager.backStackEntryCount != 0) {
        manager.popBackStackImmediate()
    }
}
fun clearStack(manager: FragmentManager) {
    val backStackCount =  manager.backStackEntryCount
    for (i in 0 until backStackCount) {

        // Get the back stack fragment id.
        val backStackId = manager.getBackStackEntryAt(i).id

        manager.popBackStack(backStackId, FragmentManager.POP_BACK_STACK_INCLUSIVE)

    }
}
fun addFragment(manager: FragmentManager, fragment: Fragment, addToBackStack: Boolean, tag: String, tipo: Int, fragment2: Fragment= HomeFragment()
                 , argumento:String="") {


    when(tipo){
        1-> {
            val transaction = manager.beginTransaction()
            transaction.add(R.id.frlayout, fragment, tag)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            if (addToBackStack) {
                transaction.addToBackStack(tag)
            }
            transaction.commitAllowingStateLoss()
        }
        2-> {
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frlayout, fragment,tag)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            if (addToBackStack) {
                transaction.addToBackStack(tag)
            }
            transaction.commitAllowingStateLoss()
        }
        3-> {
            val transaction = manager.beginTransaction()
            if (fragment.isAdded) {
                transaction
                    .hide(fragment)
                    .show(fragment2)
            } else {
                val parametro = Bundle()
                parametro.putString(tag,argumento)
                fragment.arguments = parametro

                transaction
                    .hide(fragment2)
                    .add(R.id.frlayout, fragment, tag)
            }
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            if (addToBackStack) {
                transaction.addToBackStack(tag)
            }
            transaction.commitAllowingStateLoss()
        }
        4-> {
            val parametro = Bundle()
            parametro.putString(tag,argumento)
            fragment.arguments = parametro
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frlayout, fragment,tag)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            if (addToBackStack) {
                transaction.addToBackStack(tag)
            }
            transaction.commitAllowingStateLoss()
        }
    }
}
fun addFragmentArgArray(manager: FragmentManager, fragment: Fragment, addToBackStack: Boolean, tag: String, tipo: Int, fragment2: Fragment= HomeFragment()
                        , argumento1:ArrayList<String>, argumento2:ArrayList<String>,
                        keys1: String ="", keys2: String="") {


    when(tipo){
        1-> {
            val parametro = Bundle()
            parametro.putStringArrayList(keys1,argumento1)
            parametro.putStringArrayList(keys2,argumento2)
            fragment.arguments = parametro
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.frlayout, fragment,tag)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            if (addToBackStack) {
                transaction.addToBackStack(tag)
            }
            transaction.commitAllowingStateLoss()
        }
    }
}