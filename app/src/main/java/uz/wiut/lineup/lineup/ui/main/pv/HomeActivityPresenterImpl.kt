package uz.wiut.lineup.lineup.ui.main.pv

import javax.inject.Inject

/**
 * Created by Shohruh on 19-Apr-18.
 */
class HomeActivityPresenterImpl : HomeActivityPresenter{
    @Inject
    lateinit var view : HomeActivityView

    @Inject
    constructor() {}

}