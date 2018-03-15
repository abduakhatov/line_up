package uz.wiut.lineup.lineup.ui.common.presenter

import android.os.Bundle
import uz.wiut.lineup.lineup.ui.common.view.MVPView

/**
 * Created by Shohruh on 07-Mar-18.
 */
abstract class BasePresenter<T : MVPView> : Presenter {

    protected var view: T? = null

    constructor(view: T){
        this.view = view
    }

    override fun onStart(savedInstanceState: Bundle?) {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onSaveInstanceState(outState: Bundle) {

    }

    override fun onEnd() {

    }
}