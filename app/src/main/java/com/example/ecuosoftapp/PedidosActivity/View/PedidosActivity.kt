package com.example.ecuosoftapp.PedidosActivity.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecuosoftapp.PedidosActivity.View.MyPagerAdapter
import com.example.ecuosoftapp.R
import kotlinx.android.synthetic.main.activity_pedidos.*

class PedidosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)
        val fragmentAdapter =
            MyPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
    }

}
