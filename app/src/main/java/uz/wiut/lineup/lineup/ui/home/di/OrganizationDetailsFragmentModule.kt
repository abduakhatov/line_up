package uz.wiut.lineup.lineup.ui.home.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.home.fragments.OrganizationDetailsFragment
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.OrganizationDetailsFragmentPresenter
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.OrganizationDetailsFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.OrganizationDetailsFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class OrganizationDetailsFragmentModule {

    @Binds
    @PerFragment
    abstract fun bindOrganizationDetailsFragment (fragment: OrganizationDetailsFragment) : Fragment

    @Binds
    @PerFragment
    abstract fun bindOrganizationDetailsFragmentView (fragment: OrganizationDetailsFragment) : OrganizationDetailsFragmentView

    @Binds
    @PerFragment
    abstract fun bindOrganizationDetailsFragmentPresenter (presenterImpl: OrganizationDetailsFragmentPresenterImpl) : OrganizationDetailsFragmentPresenter
}