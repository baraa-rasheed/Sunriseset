package com.bright.sunriseset.Utils

import java.util.Locale
import android.content.Context
import android.os.Build

object LocaleUtils {


   public fun getLocalizedString(context: Context, resourceId: Int): String {
        val desiredLocale = Locale.getDefault()
        val configuration = context.resources.configuration.apply {
            setLocale(desiredLocale)
            setLayoutDirection(desiredLocale)
        }
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            context.createConfigurationContext(configuration).getString(resourceId)
        } else {
            context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
            context.getString(resourceId)
        }
    }
}