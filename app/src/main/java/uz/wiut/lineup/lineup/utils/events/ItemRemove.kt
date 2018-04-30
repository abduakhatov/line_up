package uz.wiut.lineup.lineup.utils.events

import android.support.v7.widget.RecyclerView

/**
 * Created by Shohruh on 23-Apr-18.
 */
data class ItemRemove(
        var postion: Int,
        var isToRemove: Boolean = true
) {

}