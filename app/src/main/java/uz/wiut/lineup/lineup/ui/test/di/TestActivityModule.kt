package uz.wiut.lineup.lineup.ui.test.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.ui.test.TestActivity
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenter
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenterView

/**
 * Created by Shohruh on 09-Mar-18.
 */
@Module
abstract class TestActivityModule {

    @Binds
    @PerActivity
    abstract fun bindTestActivity (activity: TestActivity) : AppCompatActivity

    @Binds
    @PerActivity
    abstract fun bindTestActivityPresenterView (activity: TestActivity) : TestActivityPresenterView

    @Binds
    @PerActivity
    abstract fun bindTestActivityPresenter (presenterImpl: TestActivityPresenterImpl) : TestActivityPresenter

}