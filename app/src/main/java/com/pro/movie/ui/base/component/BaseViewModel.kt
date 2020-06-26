package com.pro.movie.ui.base.component

import androidx.lifecycle.ViewModel
import com.pro.movie.ui.base.callback.MvpView
import com.pro.movie.ui.base.callback.Presenter

/**
 * This is base view model class that maintains the bridge with presenter class
 * */
class BaseViewModel<V : MvpView, P : Presenter<V>> : ViewModel() {
    /**
     * Fields
     * */
    private var presenter: P? = null

    /**
     * Getter and setter methods for presenter
     * */
    internal fun getPresenter(): P? {
        return this.presenter
    }

    internal fun setPresenter(presenter: P) {
        if (this.presenter == null) {
            this.presenter = presenter
        }
    }

    /**
     * This method is fired when to clear the presenter
     * */
    override fun onCleared() {
        super.onCleared()
        presenter?.onPresenterDestroy()
        presenter = null
    }
}
