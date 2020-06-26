package com.pro.movie.ui.base.callback

interface SelectionListener {
    /**
     * This method is called when an item gets selected/deselected.
     *
     * @param size size of selection
     */
    fun onSelect(size: Int)
}