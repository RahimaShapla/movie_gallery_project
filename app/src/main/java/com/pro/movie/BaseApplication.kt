package com.pro.movie

import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.itechsoftsolution.ebay.utils.helper.DataUtils
import com.pro.movie.BaseApplication.Companion.sInstance
import com.pro.movie.utils.helper.SharedPrefUtils
import timber.log.Timber

/**
 * This is the Application class of the project. As we want to enable multi-dex inorder to
 * have greater quantity of methods, we are extending [MultiDexApplication] class here.
 * @property sInstance an instance of this Application class
 */
class BaseApplication : MultiDexApplication() {

    init {
        sInstance = this
    }

    companion object {
        private lateinit var sInstance: BaseApplication

        /**
         * This method provides the Application context
         * @return [Context] application context
         */
        fun getBaseApplicationContext(): Context {
            return sInstance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        DataUtils.getAndroidHashKey()

        if (applicationContext != null) {
            if (BuildConfig.DEBUG) {
                initiateOnlyInDebugMode(applicationContext)
            }
            initiate(applicationContext)
          //  DatabaseUtil.init(applicationContext)
        }
    }

    /**
     * This method only executes in debug build. Therefore, we can place our debug build specific
     * initialization here. i.e, logging library, app data watcher library etc.
     * */
    private fun initiateOnlyInDebugMode(context: Context) {
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String? {
                return super.createStackElementTag(element) +
                        " - Method:${element.methodName} - Line:${element.lineNumber}"
            }
        })
    }

    /**
     * This method executes in every build mode. Therefore, we can place our essential and common
     * initialization here. i.e, base repository, usable libraries etc
     * */
    private fun initiate(context: Context) {
       // BaseRepository.init(context)
        SharedPrefUtils.init(context)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}