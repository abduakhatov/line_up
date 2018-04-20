package uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp

import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentView
import javax.inject.Inject

/**
 * Created by Shohruh on 20-Apr-18.
 */
class SignUpFragmentPresenterImpl : SignUpFragmentPresenter {
    @Inject
    lateinit var view : SignUpFragmentView
    @Inject
    constructor()

}