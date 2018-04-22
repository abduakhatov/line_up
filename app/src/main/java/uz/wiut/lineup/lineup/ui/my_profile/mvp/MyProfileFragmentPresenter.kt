package uz.wiut.lineup.lineup.ui.my_profile.mvp

import uz.wiut.lineup.lineup.model.User

/**
 * Created by Shohruh on 20-Apr-18.
 */
interface MyProfileFragmentPresenter {
    fun loadData()
    fun onDataSave(user: User)
}