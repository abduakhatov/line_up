package uz.wiut.component.utils.ui

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by Shohruh on 13-Apr-18.
 */
class NoSwipePager : ViewPager {
    var enable: Boolean = false

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        this.enable = true;
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (this.enable) {
            super.onTouchEvent(event)
        } else false
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (this.enable) {
            super.onInterceptTouchEvent(event)
        } else false
    }

    fun setPagingEnabled(enable: Boolean) {
        this.enable = enable
    }
}