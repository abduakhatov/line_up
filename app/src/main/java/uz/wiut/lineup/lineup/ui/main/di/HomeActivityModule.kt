package uz.wiut.lineup.lineup.ui.main.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.ui.main.HomeActivity
import uz.wiut.lineup.lineup.ui.main.pv.HomeActivityPresenter
import uz.wiut.lineup.lineup.ui.main.pv.HomeActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.main.pv.HomeActivityView

/**
 * Created by Shohruh on 19-Apr-18.
 */
@Module
abstract class HomeActivityModule {

    @Binds
    @PerActivity
    abstract fun bindHomeActivity (activity: HomeActivity) : AppCompatActivity

    @Binds
    @PerActivity
    abstract fun bindHomeActivityPresenterView (activity: HomeActivity) : HomeActivityView

    @Binds
    @PerActivity
    abstract fun bindHomeActivityPresenter (presenterImpl: HomeActivityPresenterImpl) : HomeActivityPresenter
}