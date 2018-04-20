package uz.wiut.lineup.lineup.ui.sign_up_in.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignInFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentPresenter
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentView

/**
 * Created by Shohruh on 19-Apr-18.
 */
@Module
abstract class SignInFragmentModule{

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