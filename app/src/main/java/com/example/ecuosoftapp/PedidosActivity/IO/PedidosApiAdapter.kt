package com.example.ecuosoftapp.PedidosActivity.IO

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//private var server=""
//
//class PedidosApiAdapters(context: Context) {
//    val TIME_OUT=15L
//    val  BASE_URL = "http://10.0.2.2:3000/api/"
//    val control=context.getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
//    if (control.getString("x", "")=="OK") {
//            server=control.getString("a", "").toString()
//        }
//        else if (control.getString("y", "") == "OK"){
//            server=control.getString("d", "").toString()
//        }
//        else if (control.getString("z", "") == "OK"){
//            server=control.getString("g", "").toString()
//        }
//
//    val interceptor = run {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//        httpLoggingInterceptor.apply {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        }
//    }
//    val okHttpClient = OkHttpClient.Builder()
//        .addNetworkInterceptor(interceptor) // same for .addInterceptor(...)
//        .connectTimeout(TIME_OUT, TimeUnit.SECONDS) //Backend is really slow
//        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
//        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
//        .build()
//
//
//    val retrofit = Retrofit.Builder()
//        .client(okHttpClient)
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//    val request = retrofit.create(EndPoints::class.java)
//}
object PedidosApiAdapter {

val BASE_URL = "http://10.0.2.2:3000/api/"
    //"http://192.168.0.101:3000/api/"
//    private var BASE_URL = run {
//        sharedPreferences=getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
//        if (sharedPreferences.getString("x", "") == "OK") {
//            server=sharedPreferences.getString("a", "").toString()
//        }
//        else if (sharedPreferences.getString("y", "") == "OK"){
//            server=sharedPreferences.getString("d", "").toString()
//        }
//        else if (sharedPreferences.getString("z", "") == "OK"){
//            server=sharedPreferences.getString("g", "").toString()
//        }
//        return@run  server
//    }

    private val TIME_OUT: Long
        get() {
            return 15
        }
    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }
    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(interceptor) // same for .addInterceptor(...)
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS) //Backend is really slow
        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val request = retrofit.create(EndPoints::class.java)
}