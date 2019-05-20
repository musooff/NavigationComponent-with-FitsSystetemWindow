package com.example.android.navigationadvancedsample.utils

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.makeTransparentStatus() {
    if ((19 until 21).contains(Build.VERSION.SDK_INT)) {
        setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
    }
    if (Build.VERSION.SDK_INT >= 19) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
    if (Build.VERSION.SDK_INT >= 21) {
        setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        window.statusBarColor = Color.TRANSPARENT
    }
}

fun FragmentActivity.makeLightStatusBar() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}

private fun setWindowFlag(activity: FragmentActivity, bits: Int, on: Boolean) {
    activity.window.attributes.apply {
        flags = if (on) {
            flags or bits
        } else {
            flags and bits.inv()
        }
    }
}