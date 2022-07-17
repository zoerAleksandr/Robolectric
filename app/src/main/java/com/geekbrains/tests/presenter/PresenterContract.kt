package com.geekbrains.tests.presenter

import com.geekbrains.tests.view.ViewContract

internal interface PresenterContract {
    fun onAttach(v: ViewContract)
    fun onDetach()
}
