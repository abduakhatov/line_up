package uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp

import uz.wiut.lineup.lineup.ui.common.BaseActivity

/**
 * Created by Shohruh on 20-Apr-18.
 */
interface SignUpFragmentView {
    fun message(message: String)
    fun log(message: String)
    fun showVerification()
    fun hideVerification()
    fun closeFragment()
    fun startActivity(homeActivity: BaseActivity)
}