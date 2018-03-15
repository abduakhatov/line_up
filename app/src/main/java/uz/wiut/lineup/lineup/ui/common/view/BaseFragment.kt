package uz.wiut.lineup.lineup.ui.common.view

import android.app.Activity
import android.app.DialogFragment
import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.IdRes
import butterknife.ButterKnife
import butterknife.Unbinder
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Shohruh on 07-Mar-18.
 */
abstract class BaseFragment : android.support.v4.app.DialogFragment()/*, HasSupportFragmentInjector */{

    private var viewUnbinder: Unbinder? = null

    override fun onAttach(activity: Activity) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
//            AndroidSupportInjection.inject(this)
//        }
        super.onAttach(activity)
    }

    override fun onAttach(context: Context) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            AndroidSupportInjection.inject(this)
//        }
        super.onAttach(context)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        viewUnbinder = ButterKnife.bind(this, view!!)
    }

    override fun onDestroyView() {
        if (viewUnbinder != null) {
            viewUnbinder!!.unbind()
        }
        super.onDestroyView()
    }
}