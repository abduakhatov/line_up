package uz.wiut.lineup.lineup.ui.search.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.search.SearchFragment
import uz.wiut.lineup.lineup.ui.search.mvp.SearchFragmentPresenter
import uz.wiut.lineup.lineup.ui.search.mvp.SearchFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.search.mvp.SearchFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class SearchFragmentModule {
    @Binds
    @PerFragment
    abstract fun bindSearchFragment (fragment: SearchFragment) : Fragment

    @Binds
    @PerFragment
    abstract fun bindSearchFragmentView (fragment: SearchFragment) : SearchFragmentView

    @Binds
    @PerFragment
    abstract fun bindSearchFragmentPresenter (presenterImpl: SearchFragmentPresenterImpl) : SearchFragmentPresenter

}