package uz.wiut.lineup.lineup.ui.common

import android.app.DialogFragment
import android.support.annotation.IdRes
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by Shohruh on 07-Mar-18.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

//    @Inject
//    @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
//    public lateinit var fragmentMngr: android.support.v4.app.FragmentManager

    protected fun addFragment(@IdRes containerViewId: Int, fragment: android.support.v4.app.Fragment) {
//        fragmentMngr.beginTransaction()
//                .add(containerViewId, fragment)
//                .commit()
    }

    protected fun showDialogFragment(dialogFragment: DialogFragment, tag: String) {
//        dialogFragment.show(fragmentMngr, tag)
    }

}