package uz.wiut.lineup.lineup.ui.main.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.ui.main.MainActivity
import uz.wiut.lineup.lineup.ui.main.pv.MainActivityPresenter
import uz.wiut.lineup.lineup.ui.main.pv.MainActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.main.pv.MainActivityView
import uz.wiut.lineup.lineup.ui.test.TestActivity

/**
 * Created by Shohruh on 17-Mar-18.
 */
@Module
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun bindMainActivity (activity: MainActivity) : AppCompatActivity

    @Binds
    @PerActivity
    abstract fun bindMainActivityPresenterView (activity: MainActivity) : MainActivityView

    @Binds
    @PerActivity
    abstract fun bindMainActivityPresenter (presenterImpl: MainActivityPresenterImpl) : MainActivityPresenter

}