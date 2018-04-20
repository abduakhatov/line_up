package uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn

import javax.inject.Inject

/**
 * Created by Shohruh on 19-Apr-18.
 */
class SignInFragmentPresenterImpl : SignInFragmentPresenter {

    @Inject
    lateinit var view : SignInFragmentView
    @Inject
    constructor()

    override fun onSignInClicked() {
        view.signIn()
    }

    override fun onSignUpClicked() {
        view.signUp()
    }

    override fun onForgotPasswordClicked() {
        view.forgotPassword()
    }

    override fun onAnonymousClicked() {
        view.anonymous()
    }

}