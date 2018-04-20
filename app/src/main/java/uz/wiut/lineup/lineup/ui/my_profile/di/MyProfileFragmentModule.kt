package uz.wiut.lineup.lineup.ui.my_profile.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.my_profile.MyProfileFragment
import uz.wiut.lineup.lineup.ui.my_profile.mvp.MyProfileFragmentPresenter
import uz.wiut.lineup.lineup.ui.my_profile.mvp.MyProfileFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.my_profile.mvp.MyProfileFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class MyProfileFragmentModule {
    @Binds
    @PerFragment
    abstract fun bindMyProfileFragment (fragment: MyProfileFragment) : Fragment

    @Binds
    @PerFragment
    abstract fun bindMyProfileFragmentView (fragment: MyProfileFragment) : MyProfileFragmentView

    @Binds
    @PerFragment
    abstract fun bindMyProfileFragmentPresenter (presenterImpl: MyProfileFragmentPresenterImpl) : MyProfileFragmentPresenter
}