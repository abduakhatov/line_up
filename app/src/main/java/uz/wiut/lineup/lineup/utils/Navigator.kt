package uz.wiut.lineup.lineup.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.widget.Toolbar
import android.widget.Toast
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.sign_up_in.SignInUpActivity
import java.io.Serializable
import javax.inject.Inject
import android.support.v4.content.ContextCompat.startActivity
import uz.wiut.component.utils.RxBus2
import uz.wiut.lineup.lineup.utils.events.OrgDetails


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

    fun startActivity(context: Context, toCall: BaseActivity) {
        val intent = Intent(context, toCall::class.java)
        context.startActivity(intent)
    }

    fun startActivityByContext(context: Context) {
        val intent = Intent(context, context::class.java)
        context.startActivity(intent)
    }

    fun startActivityWithBundle(context: Context, toCall: BaseActivity, bundle: OrgDetails) {
        val i = Intent(context, toCall::class.java)
        i.putExtra(Constants.ORG_DETAIL, bundle)
        context.startActivity(i)
    }

    fun startActivityWithTaskClear(context: Context, toCall: BaseActivity) {
        val intent = Intent(context, toCall::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }

    fun startForResult(context: Activity, toCall: BaseActivity) {
        val intent = Intent(context, toCall::class.java)
        intent.putExtra(FOR_RESULT, true)
        context.startActivityForResult(intent, LOGIN_REQUEST_CODE)
    }

    fun setSupportActionBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    fun makeToask(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun changeFragmentWithStack(fragmentManager: FragmentManager, fragment: Fragment, className: String) {
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .addToBackStack(className)
                    .replace(R.id.flMainContent, fragment)
                    .commit()
        }
    }

    fun changeFragment(fragmentManager: FragmentManager, fragment: Fragment) {
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.flMainContent, fragment)
                    .commit()
        }
    }

    fun closeFragment(activity: FragmentActivity) {
        if (activity != null) {
            activity.supportFragmentManager.popBackStack()
        }
    }

}