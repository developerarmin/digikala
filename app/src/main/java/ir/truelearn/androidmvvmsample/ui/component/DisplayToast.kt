package ir.truelearn.androidmvvmsample.ui.component

import android.content.Context
import android.widget.Toast

fun displayToast(context:Context, message:String?){
    Toast.makeText(
        context, message,
        Toast.LENGTH_SHORT
    ).show()
}