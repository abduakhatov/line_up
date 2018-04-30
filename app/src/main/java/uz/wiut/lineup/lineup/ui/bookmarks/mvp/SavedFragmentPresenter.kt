package uz.wiut.lineup.lineup.ui.bookmarks.mvp

/**
 * Created by Shohruh on 22-Apr-18.
 */
interface SavedFragmentPresenter {
    fun onLoadData()
    fun onDestroy()
    fun subscribeRxBus()
}