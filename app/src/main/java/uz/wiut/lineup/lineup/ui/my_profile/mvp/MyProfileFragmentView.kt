package uz.wiut.lineup.lineup.ui.my_profile.mvp

import uz.wiut.lineup.lineup.model.User

/**
 * Created by Shohruh on 20-Apr-18.
 */
interface MyProfileFragmentView {
    fun setData(user: User)
    fun log(message: String)
    fun message(message: String)
    fun hideEdNameContainer()
}