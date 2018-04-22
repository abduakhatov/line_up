package uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp

import android.app.Activity
import uz.wiut.component.utils.events.Authentification
import uz.wiut.lineup.lineup.ui.common.BaseActivity

/**
 * Created by Shohruh on 20-Apr-18.
 */
interface SignUpFragmentPresenter {
    fun onSignUpClicked(name: String, phone : String, pass : String, activity: Activity)
    fun onVerifyClicked(code: String)
    fun onUserVerificationCalledFromSignInFrgmt(auth : Authentification, activity: Activity)
}