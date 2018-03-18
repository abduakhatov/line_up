package uz.wiut.lineup.lineup.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.Toolbar
import javax.inject.Inject
import javax.inject.Singleton
import android.support.v4.app.Fragment
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.test.TestActivity

/**
 * Created by Shohruh on 07-Mar-18.
 */

//@Singleton
class Navigator {

    companion object {
        val FOR_RESULT = "forResult"
        val LOGIN_REQUEST_CODE = 22
    }

    @Inject
    constructor()

    fun startActivity(context: Context, toCall : BaseActivity) {
        val intent = Intent(context, toCall::class.java)
        context.startActivity(intent)
    }

    fun startActivityWithTaskClear(context: Context, toCall : BaseActivity) {
        val intent = Intent(context, toCall::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }

    fun startForResult(context: Activity, toCall : BaseActivity) {
        val intent = Intent(context, toCall::class.java)
        intent.putExtra(FOR_RESULT, true)
        context.startActivityForResult(intent, LOGIN_REQUEST_CODE)
    }

    fun startFragment(context: Context, fragment: Fragment) {
        val intent = Intent(context, fragment::class.java)
        context.startActivity(intent)
    }

    fun setSupportActionBar(toolbar: Toolbar){
        setSupportActionBar(toolbar)
    }
}