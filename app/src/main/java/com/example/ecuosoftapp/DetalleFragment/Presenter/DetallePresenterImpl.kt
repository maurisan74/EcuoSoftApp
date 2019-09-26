package com.example.ecuosoftapp.DetalleFragment.Presenter

import com.example.ecuosoftapp.DetalleFragment.Interfaces.DetallePresenter
import com.example.ecuosoftapp.DetalleFragment.View.DetalleFragment

class DetallePresenterImpl(var view: DetalleFragment): DetallePresenter {
    override fun ShowProgressBarPresenter(mostrar: Boolean) {
        view.ShowProgressBar(mostrar)
    }
}