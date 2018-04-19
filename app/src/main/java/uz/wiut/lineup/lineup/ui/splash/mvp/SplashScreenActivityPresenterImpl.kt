package uz.wiut.lineup.lineup.ui.splash.mvp

import javax.inject.Inject

/**
 * Created by Shohruh on 19-Apr-18.
 */
class SplashScreenActivityPresenterImpl : SplashScreenActivityPresenter {
    @Inject
    lateinit var view : SplashScreenActivityView

    @Inject
    constructor() {}

    override fun touch() {
        view.callPhone();
    }
}