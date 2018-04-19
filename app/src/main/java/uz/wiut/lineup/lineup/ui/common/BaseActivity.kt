package uz.wiut.lineup.lineup.ui.common

import dagger.android.support.DaggerAppCompatActivity
import uz.wiut.lineup.lineup.utils.Navigator
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Shohruh on 07-Mar-18.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    @Named(BaseActivityModule.ACTIVITY_NAVIGATOR)
    lateinit var navigator: Navigator

//    @Inject
//    @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
//    lateinit var fragmentMngr: android.support.v4.app.FragmentManager
//
//    protected fun addFragment(@IdRes containerViewId: Int, fragment: android.support.v4.app.Fragment) {
//        fragmentMngr.beginTransaction()
//                .add(containerViewId, fragment)
//                .commit()
//    }

//    protected fun showDialogFragment(dialogFragment: DialogFragment, tag: String) {
////        dialogFragment.show(fragmentMngr, tag)
//    }

}