package uz.wiut.lineup.lineup.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.Toolbar

/**
 * Created by Shohruh on 07-Mar-18.
 */

//@Singleton
class Navigator {
//    @Inject
//    constructor()

    fun startActivity(context: Context, activity: Activity) {
        val intent = Intent(context, activity::class.java)
        context.startActivity(intent)
    }

//    fun startFragment(context: Context, fragment: Fragment) {
//        val intent = Intent(context, fragment::class.java)
//        context.startActivity(intent)
//    }

    fun setSupportActionBar(toolbar: Toolbar){
        setSupportActionBar(toolbar)
    }
}