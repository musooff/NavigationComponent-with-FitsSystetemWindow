package com.example.android.navigationadvancedsample.custom

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.WindowInsets
import android.widget.FrameLayout

/**
 * A FrameLayout subclass that dispatches WindowInsets to its children instead of adjusting its padding.
 * Useful for Fragment containers.
 */
class WindowInsetsFrameLayout : FrameLayout {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        val childCount = childCount
        for (index in 0 until childCount)
            getChildAt(index).dispatchApplyWindowInsets(insets)

        return insets
    }
}