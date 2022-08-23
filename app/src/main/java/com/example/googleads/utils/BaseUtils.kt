package com.example.googleads.utils

import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class BaseUtils {
    companion object{

        fun showMessage(view: View, message: String, isError: Boolean = false) {
            val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            val snackBarView = snackBar.view
            val context = view.context
            if (isError) {
                snackBarView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light))
            } else {
                snackBarView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.black))
            }
            snackBar.show()
        }

    }
}