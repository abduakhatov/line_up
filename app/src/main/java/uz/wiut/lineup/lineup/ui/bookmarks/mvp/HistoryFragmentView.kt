package uz.wiut.lineup.lineup.ui.bookmarks.mvp

import uz.wiut.lineup.lineup.model.History
import uz.wiut.lineup.lineup.model.Organization

/**
 * Created by Shohruh on 22-Apr-18.
 */
interface HistoryFragmentView {
    fun setBookmarkData(historyList: ArrayList<History>)
    fun setOrganizationData(organization: ArrayList<Organization>)
    fun log(message: String)
    fun message(message: String)
}