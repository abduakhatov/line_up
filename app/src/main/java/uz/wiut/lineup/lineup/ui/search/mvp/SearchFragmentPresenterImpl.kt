package uz.wiut.lineup.lineup.ui.search.mvp

import dagger.Module
import javax.inject.Inject

/**
 * Created by Shohruh on 20-Apr-18.
 */
class SearchFragmentPresenterImpl : SearchFragmentPresenter {

    @Inject
    lateinit var view : SearchFragmentView

    @Inject
    constructor()
}
