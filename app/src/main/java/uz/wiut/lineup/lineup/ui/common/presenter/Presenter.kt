package uz.wiut.lineup.lineup.ui.common.presenter

import android.os.Bundle

/**
 * Created by Shohruh on 07-Mar-18.
 */
interface Presenter {
    fun onStart(savedInstanceState: Bundle?)
    fun onResume()
    fun onPause()
    fun onSaveInstanceState(outState: Bundle)
    fun onEnd()
}