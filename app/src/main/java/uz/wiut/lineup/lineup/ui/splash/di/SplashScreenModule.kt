package uz.wiut.lineup.lineup.ui.splash.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.ui.splash.SplashScreenActivity

/**
 * Created by Shohruh on 19-Apr-18.
 */
@Module
abstract class SplashScreenModule {
    @Binds
    @PerActivity
    abstract fun bindSplashCreenActivity (activity: SplashScreenActivity) : AppCompatActivity

//    @Binds
//    @PerActivity
//    abstract fun bindSplashCreenActivityView (activity: SplashScreenActivity) : SplashScreenActivityView
//
//    @Binds
//    @PerActivity
//    abstract fun bindSplashCreenActivityPresenter (presenterImpl: SplashScreenActivityPresenterImpl) : SplashScreenActivityPresenter


}