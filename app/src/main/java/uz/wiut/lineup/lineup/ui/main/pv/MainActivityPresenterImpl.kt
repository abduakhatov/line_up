package uz.wiut.lineup.lineup.ui.main.pv

import javax.inject.Inject

/**
 * Created by Shohruh on 17-Mar-18.
 */

class MainActivityPresenterImpl : MainActivityPresenter{
    @Inject
    lateinit var view : MainActivityView

    @Inject
    constructor() {}

}