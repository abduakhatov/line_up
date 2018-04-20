package uz.wiut.lineup.lineup.ui.search.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerChildFragment
import uz.wiut.lineup.lineup.ui.search.fragments.CitySearchFragment
import uz.wiut.lineup.lineup.ui.search.mvp.city.CitySearchFragmentPresenter
import uz.wiut.lineup.lineup.ui.search.mvp.city.CitySearchFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.search.mvp.city.CitySearchFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class CitySearchFragmentModule {

    @Binds
    @PerChildFragment
    abstract fun bindCitySearchFragment (fragment: CitySearchFragment) : Fragment

    @Binds
    @PerChildFragment
    abstract fun bindCitySearchFragmentView (fragment: CitySearchFragment) : CitySearchFragmentView

    @Binds
    @PerChildFragment
    abstract fun bindCitySearchFragmentPresenter (presenterImpl: CitySearchFragmentPresenterImpl) : CitySearchFragmentPresenter
}