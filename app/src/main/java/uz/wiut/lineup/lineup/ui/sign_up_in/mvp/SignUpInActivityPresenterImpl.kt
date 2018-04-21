package uz.wiut.lineup.lineup.ui.sign_up_in.mvp

import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenterView
import javax.inject.Inject

/**
 * Created by Shohruh on 19-Apr-18.
 */

class SignUpInActivityPresenterImpl : SignUpInActivityPresenter{

    @Inject
    lateinit var view : SignInUpActivityView

    @Inject
    constructor()

}