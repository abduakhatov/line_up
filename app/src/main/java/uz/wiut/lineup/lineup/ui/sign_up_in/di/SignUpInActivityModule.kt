package uz.wiut.lineup.lineup.ui.sign_up_in.di

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.SignInUpActivity
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignInFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.*
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentPresenter
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentView

/**
 * Created by Shohruh on 19-Apr-18.
 */
@Module
abstract class SignUpInActivityModule {
    // Activity
    @Binds
    @PerActivity
    abstract fun bindSignUpInActivity (activity: SignInUpActivity) : AppCompatActivity

    @Binds
    @PerActivity
    abstract fun bindSignUpInActivityPresenterView (activity: SignInUpActivity) : SignInUpActivityView

    @Binds
    @PerActivity
    abstract fun bindSignUpInActivityPresenter (presenterImpl: SignUpInActivityPresenterImpl) : SignUpInActivityPresenter
}