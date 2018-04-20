package uz.wiut.lineup.lineup.ui.sign_up_in.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignUpFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp.SignUpFragmentPresenter
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp.SignUpFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp.SignUpFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class SignUpFragmentModule {
    @Binds
    @PerFragment
    abstract fun bindSignUpFragment (fragment: SignUpFragment) : Fragment

    @Binds
    @PerFragment
    abstract fun bindSignUpFragmentView (fragment: SignUpFragment) : SignUpFragmentView

    @Binds
    @PerFragment
    abstract fun bindSignUpFragmentPresenter (presenterImpl: SignUpFragmentPresenterImpl) : SignUpFragmentPresenter

}