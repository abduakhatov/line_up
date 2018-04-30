package uz.wiut.lineup.lineup.ui.organizationDetails.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.ui.organizationDetails.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.ui.organizationDetails.mvp.OrganizationDetailsActivityPresenter
import uz.wiut.lineup.lineup.ui.organizationDetails.mvp.OrganizationDetailsActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.organizationDetails.mvp.OrganizationDetailsActivityView

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