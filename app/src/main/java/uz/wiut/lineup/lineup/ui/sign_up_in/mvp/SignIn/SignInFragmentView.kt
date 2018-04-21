package uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn

/**
 * Created by Shohruh on 19-Apr-18.
 */
interface SignInFragmentView {
    fun signIn()
    fun signUp()
    fun forgotPassword()
    fun anonymous()
    fun message(message: String)
    fun log(message: String)
}