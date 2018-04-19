package uz.wiut.lineup.lineup.ui.sign_up_in.di

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerFragment
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.SignInUpActivity
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignInFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.*

/**
 * Created by Shohruh on 19-Apr-18.
 */
@Module
abstract class SignUpInActivityModule {
    @Binds
    @PerActivity
    abstract fun bindSignUpInActivity (activity: SignInUpActivity) : AppCompatActivity

    @Binds
    @PerActivity
    abstract fun bindSignUpInActivityPresenterView (activity: SignInUpActivity) : SignInUpActivityView

    @Binds
    @PerActivity
    abstract fun bindSignUpInActivityPresenter (presenterImpl: SignUpInActivityPresenterImpl) : SignUpInActivityPresenter

    @Binds
    @PerFragment
    abstract fun bindSignInFragment (fragment: SignInFragment) : Fragment

    @Binds
    @PerFragment
    abstract fun bindSignInFragmentView (fragment: SignInFragment) : SignInFragmentView

    @Binds
    @PerFragment
    abstract fun bindSignInFragmentPresenter (presenterImpl: SignInFragmentPresenterImpl) : SignInFragmentPresenter
}