package com.example.ecuosoftapp.View

import android.Manifest
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.ecuosoftapp.*
import com.example.ecuosoftapp.SaveFragment.View.SaveFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var backPressedTime: Long = 0
    private var backToast: Toast? = null

    companion object {

        var VIBRATOR_PERMISSION_REQUEST_CODE=0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.VIBRATE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.VIBRATE),VIBRATOR_PERMISSION_REQUEST_CODE)
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.VIBRATE)) {
            VIBRATOR_PERMISSION_REQUEST_CODE=1
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
            if (savedInstanceState == null) this.onNavigationItemSelected(nav_view.menu.getItem(7))
            this.Msje( "!No hay ningun Servidor Predeterminado¡")

        }
        else
        {
            if (savedInstanceState == null) this.onNavigationItemSelected(nav_view.menu.getItem(0))
            //Esta linea es para que al iniciar el main activity se cargue el primer fragment, o sea el home
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
//            if (backPressedTime + 3000 > System.currentTimeMillis()) {
//                backToast!!.cancel()
                super.onBackPressed()
//                finish()
//                return
//            } else {
//                backToast = Toast.makeText(baseContext, "!Presione dos veces para salir¡", Toast.LENGTH_SHORT)
//                backToast!!.show()
//            }
//            backPressedTime = System.currentTimeMillis()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frlayout, SaveFragment())
            .addToBackStack(null)
            .commit()
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        when (item.itemId) {
            R.id.nav_home -> {
                if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
                    addFragment( supportFragmentManager, SaveFragment(), true, "SaveFragment",1)
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.frlayout,
//                            SaveFragment()
//                        )
//                        .addToBackStack(null)
//                        .commit()
                    this.Msje( "!No hay ningun Servidor Predeterminado¡")
                }else {

                    if (VIBRATOR_PERMISSION_REQUEST_CODE == 1) vibrate(50)
                    addFragment( supportFragmentManager, HomeFragment(), true, "HomeFragment",1)
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.frlayout, HomeFragment())
//                        .addToBackStack(null)
//                        .commit()
                }
            }
            R.id.nav_aut_comp -> {
                if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
                    addFragment( supportFragmentManager, SaveFragment(), true, "null",1)
                    this.Msje( "!No hay ningun Servidor Predeterminado¡")
                }else {
                    if (VIBRATOR_PERMISSION_REQUEST_CODE == 1) vibrate(50)

                    addFragment( supportFragmentManager, CompFragment(), true, "CompFragment",2)

                }
            }
            R.id.nav_pedido_trabajo -> {
                if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
                    addFragment( supportFragmentManager, SaveFragment(), true, "null",1)

                    this.Msje( "!No hay ningun Servidor Predeterminado¡")
                }else {
                    if (VIBRATOR_PERMISSION_REQUEST_CODE == 1) vibrate(50)
                }
            }
            R.id.nav_ordenes -> {
                if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
                        addFragment( supportFragmentManager, SaveFragment(), true, "SaveFragment",1)
                    this.Msje( "!No hay ningun Servidor Predeterminado¡")
                }else {

                    if (VIBRATOR_PERMISSION_REQUEST_CODE == 1) vibrate(50)
                }
            }
            R.id.nav_alertas -> {

                if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
                    addFragment( supportFragmentManager, SaveFragment(), true, "SaveFragment",1)
                    this.Msje( "!No hay ningun Servidor Predeterminado¡")
                }else {

                    if (VIBRATOR_PERMISSION_REQUEST_CODE == 1) vibrate(50)
                }
            }
            R.id.nav_fichas -> {
                if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
                    addFragment( supportFragmentManager, SaveFragment(), true, "null",1)
                    this.Msje( "!No hay ningun Servidor Predeterminado¡")
                }else {

                    if (VIBRATOR_PERMISSION_REQUEST_CODE == 1) vibrate(50)
                }
            }
            R.id.nav_pedido_compra -> {
                if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
                    addFragment( supportFragmentManager, SaveFragment(), false, "null",1)
                this.Msje( "!No hay ningun Servidor Predeterminado¡")
            }else {

                    if (VIBRATOR_PERMISSION_REQUEST_CODE == 1) vibrate(50)
                }
            }

            R.id.nav_conf -> {
                if (sharedPreferences.getString("x", "") == "" && sharedPreferences.getString("y","") == "" && sharedPreferences.getString("z", "") == "") {
                    addFragment( supportFragmentManager, SaveFragment(), true, "",1)
                    this.Msje( "!No hay ningun Servidor Predeterminado¡")
                }else {

                    if (VIBRATOR_PERMISSION_REQUEST_CODE == 1) vibrate(50)
                    addFragment( supportFragmentManager, SaveFragment(), true, "SaveFragment",2)
                }
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}