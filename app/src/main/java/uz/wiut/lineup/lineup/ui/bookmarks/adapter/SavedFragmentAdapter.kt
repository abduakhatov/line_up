package uz.wiut.lineup.lineup.ui.bookmarks.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.wiut.component.utils.RxBus2
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.Bookmark
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.ui.common.holder.BaseViewHolder
import uz.wiut.lineup.lineup.utils.events.ItemRemove

/**
 * Created by Shohruh on 23-Apr-18.
 */
class SavedFragmentAdapter(
        private val context: Context,
        private var list: ArrayList<Organization>,
        private var orgs: ArrayList<Bookmark>
) : RecyclerView.Adapter<BaseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder
            = BaseViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_home_list, parent, false))

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
            var org: Organization = list.get(position)

//        holder?.cvActiveQueueItem?.setOnClickListener(View.OnClickListener {
//
//        })
        holder?.tvLocation?.text = org.locationTitle
        holder?.tvOpenClosed?.visibility = View.GONE
//        when(org.isOpen){
//            -1 -> {
//                holder?.tvOpenClosed?.text = Constants.CLOSED
//                holder?.tvOpenClosed?.setTextColor(Color.RED)
//            }
//            0 -> {
//                holder?.tvOpenClosed?.text = Constants.BREAK
//                holder?.tvOpenClosed?.setTextColor(Color.YELLOW)
//            }
//            1 -> {
//                holder?.tvOpenClosed?.text = Constants.OPEN
//                holder?.tvOpenClosed?.setTextColor(Color.GREEN)
//            }
//        }

        holder?.ivBookmark?.setOnClickListener(View.OnClickListener {
            holder?.ivBookmark?.setImageResource(R.drawable.ic_like)
            list.removeAt(position)
            notifyItemRemoved(position)
            RxBus2.publish(RxBus2.ITEM_DELETE, ItemRemove(position))
        })
        holder?.ivBookmark?.setImageResource(R.drawable.ic_liked)

        holder?.tvNameOfOrg?.text = org.name
        holder?.llTitleContainer?.visibility = View.GONE
        holder?.tvApproximateTime  // todo take from queue
        holder?.tvApproximateTime?.visibility = View.GONE  // todo take from queue
        holder?.tvWaitingPeople?.visibility = View.GONE // todo take from queue
        holder?.tvWaitingPeople?.text // todo take from queue
    }


}

