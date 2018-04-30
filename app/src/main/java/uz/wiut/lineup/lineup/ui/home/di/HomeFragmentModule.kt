package uz.wiut.lineup.lineup.ui.home.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.home.HomeFragment
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.HomeFragmentPresenter
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.HomeFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.HomeFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class HomeFragmentModule {
    @Binds
    @PerFragment
    abstract fun bindHomeFragment (fragment: HomeFragment) : Fragment

    @Binds
    @PerFragment
    abstract fun bindHomeFragmentView (fragment: HomeFragment) : HomeFragmentView

    @Binds
    @PerFragment
    abstract fun bindHomeFragmentPresenter (presenterImpl: HomeFragmentPresenterImpl) : HomeFragmentPresenter
}