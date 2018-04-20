package uz.wiut.lineup.lineup.ui.sign_up_in.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.VerificationFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.Verification.VerificationFragmentPresenter
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.Verification.VerificationFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.Verification.VerificationFragmentView

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class VerificationFragmentModule {
    @Binds
    @PerFragment
    abstract fun bindVerificationFragment (fragment: VerificationFragment) : Fragment

    @Binds
    @PerFragment
    abstract fun bindVerificationFragmentView (fragment: VerificationFragment) : VerificationFragmentView

    @Binds
    @PerFragment
    abstract fun bindVerificationFragmentPresenter (presenterImpl: VerificationFragmentPresenterImpl) : VerificationFragmentPresenter

}