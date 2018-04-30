package uz.wiut.lineup.lineup.ui.bookmarks.mvp

import uz.wiut.lineup.lineup.model.Bookmark
import uz.wiut.lineup.lineup.model.Organization

/**
 * Created by Shohruh on 22-Apr-18.
 */
interface SavedFragmentView {
    fun setOrganizationData(organization: ArrayList<Organization>)
    fun setBookmarkData(bookmarkList: ArrayList<Bookmark>)
    fun log(message: String)
    fun message(message: String)
}