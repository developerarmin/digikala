package ir.truelearn.androidmvvmsample

import android.annotation.TargetApi
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.Locale

object LocaleHelper {

    fun setLocale(context: Context,language: String):Context?{
        App.myLanguage = language
         return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResource(context,language)
        } else {
            updateResourcesLegacy(context,language)
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResource(context: Context,language : String) : Context? {
        val locale : Locale = Locale(language)
        Locale.setDefault(locale)
        val configuration : Configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        return context.createConfigurationContext(configuration)
    }

    private fun updateResourcesLegacy(context: Context,language: String) : Context {
        val locale  = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration : Configuration = resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration,resources.displayMetrics)
        return context
    }
}