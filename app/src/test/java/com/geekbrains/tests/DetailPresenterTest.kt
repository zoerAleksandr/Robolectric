package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailPresenterTest {
    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        presenter = DetailsPresenter()
        presenter.onAttach(viewContract)
    }

    @Test
    fun onAttach_Test() {
        assertNotNull(presenter.viewContract)
    }

    @Test
    fun onDetach_Test(){
        presenter.onDetach()
        assertNull(presenter.viewContract)
    }

    @Test
    fun onIncrement_Test() {
        presenter.onIncrement()
        verify(viewContract).setCount(1)
    }

    @Test
    fun onDecrement_Test() {
        presenter.onDecrement()
        verify(viewContract).setCount(-1)
    }
}