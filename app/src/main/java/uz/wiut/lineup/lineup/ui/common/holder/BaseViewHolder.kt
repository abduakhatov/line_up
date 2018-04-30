package uz.wiut.lineup.lineup.ui.common.holder

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import uz.wiut.lineup.lineup.R

/**
 * Created by Shohruh on 23-Apr-18.
 */
class BaseViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var cvActiveQueueItem: CardView
    var tvLocation: TextView
    var tvOpenClosed: TextView
    var ivBookmark: ImageView
    var tvNameOfOrg: TextView
    var tvApproximateTime: TextView
    var tvWaitingPeople: TextView
    var llHistoryContainer: LinearLayout
    var llTitleContainer: LinearLayout
    var tvLastVisit: TextView

    init {
        cvActiveQueueItem = v.findViewById(R.id.cvActiveQueueItem)
        tvLocation = v.findViewById(R.id.tvLocation)
        tvOpenClosed = v.findViewById(R.id.tvOpenClosed)
        ivBookmark = v.findViewById(R.id.ivBookmark)
        tvNameOfOrg = v.findViewById(R.id.tvNameOfOrg)
        tvApproximateTime = v.findViewById(R.id.tvApproximateTime)
        tvWaitingPeople = v.findViewById(R.id.tvWaitingPeople)
        llHistoryContainer = v.findViewById(R.id.llHistoryContainer)
        llTitleContainer = v.findViewById(R.id.llTitleContainer)
        tvLastVisit = v.findViewById(R.id.tvLastVisit)
    }
}