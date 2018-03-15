package uz.wiut.lineup.lineup.ui.common.view

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.annotation.CallSuper
import dagger.android.AndroidInjector
import uz.wiut.lineup.lineup.ui.common.presenter.Presenter
import javax.inject.Inject

/**
 * Created by Shohruh on 07-Mar-18.
 */
abstract class BaseViewFragment<T : Presenter> : BaseFragment(), MVPView {

//    @Inject
//    public lateinit var presenter: T


    override fun onResume() {
        super.onResume()
//        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
//        presenter.onPause()
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        presenter.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
//        presenter.onEnd()
        super.onDestroyView()
    }
}