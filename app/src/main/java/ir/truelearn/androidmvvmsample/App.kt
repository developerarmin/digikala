package ir.truelearn.androidmvvmsample

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import dagger.hilt.android.HiltAndroidApp
import java.util.Locale

@HiltAndroidApp
class App : Application() {


    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var currentActivity: Activity
        fun setActivity(activity: Activity) {
            currentActivity = activity
        }

        fun getCurrentActivity(): Activity {
            return currentActivity
        }
    }

}