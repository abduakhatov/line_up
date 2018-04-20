package uz.wiut.lineup.lineup.ui.home.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.ui.home.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.ui.home.mvp.OrganizationDetailsActivityPresenter
import uz.wiut.lineup.lineup.ui.home.mvp.OrganizationDetailsActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.home.mvp.OrganizationDetailsActivityView

/**
 * Created by Shohruh on 19-Apr-18.
 */
@Module
abstract class OrganizationDetailsActivityModule {
    @Binds
    @PerActivity
    abstract fun bindOrganizationDetailsActivity (activity: OrganizationDetailsActivity) : AppCompatActivity

    @Binds
    @PerActivity
    abstract fun bindOrganizationDetailsActivityPresenterView (activity: OrganizationDetailsActivity) : OrganizationDetailsActivityView

    @Binds
    @PerActivity
    abstract fun bindOrganizationDetailsActivityPresenter (presenterImpl: OrganizationDetailsActivityPresenterImpl) : OrganizationDetailsActivityPresenter
}