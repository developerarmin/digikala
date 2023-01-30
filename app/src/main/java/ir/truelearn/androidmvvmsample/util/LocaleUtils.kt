package ir.truelearn.androidmvvmsample.util

import android.content.Context
import android.content.res.Configuration
import java.util.*

object LocaleUtils {

    fun setLocale(c: Context, language: String) = updateResources(c, language = "fa")

    private fun updateResources(context: Context, language: String) {
        context.resources.apply {
            val locale = Locale(language)
            val config = Configuration(configuration)

            context.createConfigurationContext(configuration)
            Locale.setDefault(locale)
            config.setLocale(locale)
            context.resources.updateConfiguration(config, displayMetrics)
        }
    }
}