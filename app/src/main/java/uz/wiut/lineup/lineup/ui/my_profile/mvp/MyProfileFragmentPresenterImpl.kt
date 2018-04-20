package uz.wiut.lineup.lineup.ui.my_profile.mvp

import javax.inject.Inject

/**
 * Created by Shohruh on 20-Apr-18.
 */
class MyProfileFragmentPresenterImpl : MyProfileFragmentPresenter{
    @Inject
    lateinit var view : MyProfileFragmentView

    @Inject
    constructor()
}