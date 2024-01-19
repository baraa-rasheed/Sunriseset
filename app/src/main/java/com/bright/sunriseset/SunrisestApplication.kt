package com.bright.sunriseset

import android.app.Application
import android.os.Build
import java.util.Locale

class SunrisestApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val desiredLocale =     Locale("zh","rCN")
        Locale.setDefault(desiredLocale)

        resources.configuration.setLocale(desiredLocale)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val configuration = resources.configuration.apply {
                setLocale(desiredLocale)
                setLayoutDirection(desiredLocale) // Ensure correct layout direction
            }
            createConfigurationContext(configuration)
        } else {
            val configuration = resources.configuration
            configuration.locale = desiredLocale
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }
    }
}