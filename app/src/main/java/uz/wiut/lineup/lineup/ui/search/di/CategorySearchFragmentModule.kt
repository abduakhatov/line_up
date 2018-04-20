package uz.wiut.lineup.lineup.ui.search.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerChildFragment
import uz.wiut.lineup.lineup.ui.search.fragments.CategorySearchFragment
import uz.wiut.lineup.lineup.ui.search.mvp.category.CategorySearchFragmentPresenter
import uz.wiut.lineup.lineup.ui.search.mvp.category.CategorySearchFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.search.mvp.category.CategorySearchFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class CategorySearchFragmentModule {

    @Binds
    @PerChildFragment
    abstract fun bindCategorySearchFragment (fragment: CategorySearchFragment) : Fragment

    @Binds
    @PerChildFragment
    abstract fun bindCategorySearchFragmentView (fragment: CategorySearchFragment) : CategorySearchFragmentView

    @Binds
    @PerChildFragment
    abstract fun bindCategorySearchFragmentPresenter (presenterImpl: CategorySearchFragmentPresenterImpl) : CategorySearchFragmentPresenter
}