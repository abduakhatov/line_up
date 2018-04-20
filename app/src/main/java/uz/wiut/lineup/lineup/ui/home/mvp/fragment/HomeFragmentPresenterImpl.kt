package uz.wiut.lineup.lineup.ui.home.mvp.fragment

import javax.inject.Inject

/**
 * Created by Shohruh on 20-Apr-18.
 */
class HomeFragmentPresenterImpl : HomeFragmentPresenter {
    @Inject
    lateinit var view : HomeFragmentView

    @Inject
    constructor()
}