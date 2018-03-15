package uz.wiut.lineup.lineup.ui.test.presenter

import javax.inject.Inject

/**
 * Created by Shohruh on 09-Mar-18.
 */
class TestActivityPresenterImpl : TestActivityPresenter {
    @Inject
    lateinit var view : TestActivityPresenterView

    @Inject
    constructor() {}

    override fun touch() {
        view.callPhone();
    }
}