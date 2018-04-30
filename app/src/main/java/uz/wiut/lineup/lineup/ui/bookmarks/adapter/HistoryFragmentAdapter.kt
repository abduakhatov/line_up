package uz.wiut.lineup.lineup.ui.bookmarks.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.History
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.ui.common.holder.BaseViewHolder
import uz.wiut.lineup.lineup.utils.Constants

/**
 * Created by Shohruh on 23-Apr-18.
 */
class HistoryFragmentAdapter (
        private val context: Context,
        private var list: ArrayList<Organization>,
        private var histries: ArrayList<History>
) : RecyclerView.Adapter<BaseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder
            = BaseViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_home_list, parent, false))

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        var org: Organization = list.get(position)
        var history: History = histries.get(position)

        holder?.tvLocation?.text = org.locationTitle
        holder?.tvNameOfOrg?.text = org.name
        holder?.llHistoryContainer?.visibility = View.VISIBLE
        holder?.tvLastVisit?.text = Constants.getDate(history.lastVisit, "MMM dd, yyyy")

        holder?.tvOpenClosed?.visibility = View.GONE
        holder?.ivBookmark?.visibility = View.GONE
        holder?.llTitleContainer?.visibility = View.GONE
        holder?.tvApproximateTime?.visibility = View.GONE
        holder?.tvWaitingPeople?.visibility = View.GONE
    }

}