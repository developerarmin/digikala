package ir.truelearn.androidmvvmsample

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import java.util.Locale

@HiltAndroidApp
class App : Application() {
    companion object {
        // store the language in myLanguage variable
        var myLanguage : String = Locale.getDefault().language
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base?.let { LocaleHelper.setLocale(it, myLanguage) })
    }
}