package com.pro.movie.utils.helper.network

import com.itechsoftsolution.ebay.utils.helper.DataUtils
import com.pro.movie.R
import java.io.IOException

/**
 * This is an exception class for no connectivity of internet
 * */
class NoConnectivityException : IOException() {
    override val message: String
        get() = DataUtils.getString(R.string.error_internet_connection)
}
