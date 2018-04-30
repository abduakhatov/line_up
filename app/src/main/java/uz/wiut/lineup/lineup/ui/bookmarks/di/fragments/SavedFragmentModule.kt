package uz.wiut.lineup.lineup.ui.bookmarks.di.fragments

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerChildFragment
import uz.wiut.lineup.lineup.ui.bookmarks.fragments.SavedBookmarkFragment
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.SavedFragmentPresenter
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.SavedFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.SavedFragmentView

/**
 * Created by Shohruh on 22-Apr-18.
 */

@Module
abstract class SavedFragmentModule(){
    @Binds
    @PerChildFragment
    abstract fun bindSavedBookmarkFragment (fragment: SavedBookmarkFragment) : Fragment

    @Binds
    @PerChildFragment
    abstract fun bindSavedBookmarkFragmentView (fragment: SavedBookmarkFragment) : SavedFragmentView

    @Binds
    @PerChildFragment
    abstract fun bindSavedBookmarkFragmentPresenter (presenterImpl: SavedFragmentPresenterImpl) : SavedFragmentPresenter
}