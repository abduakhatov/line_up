package uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn

/**
 * Created by Shohruh on 19-Apr-18.
 */
interface SignInFragmentPresenter {
    fun onSignInClicked(phone: String, password: String )
    fun onSignUpClicked()
    fun onForgotPasswordClicked()
    fun onAnonymousClicked()

}