package uz.wiut.lineup.lineup.ui.bookmarks.di.fragments

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerChildFragment
import uz.wiut.lineup.lineup.ui.bookmarks.fragments.HistoryOfBookmarksFragment
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.HistoryFragmentPresenter
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.HistoryFragmentView
import uz.wiut.lineup.lineup.ui.histories.mvp.HistoryFragmentPresenterImpl

/**
 * Created by Shohruh on 22-Apr-18.
 */
@Module
abstract class HistoryFragmentModule{

    @Binds
    @PerChildFragment
    abstract fun bindHistoryFragment (fragment: HistoryOfBookmarksFragment) : Fragment

    @Binds
    @PerChildFragment
    abstract fun bindHistoryFragmentView (fragment: HistoryOfBookmarksFragment) : HistoryFragmentView

    @Binds
    @PerChildFragment
    abstract fun bindHistoryFragmentPresenter (presenterImpl: HistoryFragmentPresenterImpl) : HistoryFragmentPresenter

}