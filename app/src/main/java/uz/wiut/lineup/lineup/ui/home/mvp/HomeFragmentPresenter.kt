package uz.wiut.lineup.lineup.ui.home.mvp.fragment

/**
 * Created by Shohruh on 20-Apr-18.
 */
interface HomeFragmentPresenter {
    fun onLoadData()
    fun subscribeRxBus()
    fun onDestroy()
}