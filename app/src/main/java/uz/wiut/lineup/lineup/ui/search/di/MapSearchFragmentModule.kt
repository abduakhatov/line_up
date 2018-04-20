package uz.wiut.lineup.lineup.ui.search.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerChildFragment
import uz.wiut.lineup.lineup.ui.search.fragments.MapSearchFragment
import uz.wiut.lineup.lineup.ui.search.mvp.map.MapSearchFragmentPresenter
import uz.wiut.lineup.lineup.ui.search.mvp.map.MapSearchFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.search.mvp.map.MapSearchFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class MapSearchFragmentModule {
    @Binds
    @PerChildFragment
    abstract fun bindMapSearchFragment (fragment: MapSearchFragment) : Fragment

    @Binds
    @PerChildFragment
    abstract fun bindMapSearchFragmentView (fragment: MapSearchFragment) : MapSearchFragmentView

    @Binds
    @PerChildFragment
    abstract fun bindMapSearchFragmentPresenter (presenterImpl: MapSearchFragmentPresenterImpl) : MapSearchFragmentPresenter
}