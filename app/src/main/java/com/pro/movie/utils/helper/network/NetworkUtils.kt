package com.pro.movie.utils.helper.network

import android.content.Context
import android.net.ConnectivityManager
import com.pro.movie.BaseApplication

/**
 * This is a class that contains utils to work with network
 * */
object NetworkUtils {

    /**
     * This method returns the state of an internet connection
     *
     * @return true if the connection is online else false
     * */
    @Synchronized
    fun isOnline(): Boolean {
        val connectivityManager =
                BaseApplication.getBaseApplicationContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return (netInfo != null && netInfo.isConnected)
    }
}