package uz.wiut.lineup.lineup.ui.search.adapter

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import uz.wiut.component.utils.RxBus2
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.toDelete.Organzatn
import uz.wiut.lineup.lineup.ui.organizationDetails.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.ItemRemove
import uz.wiut.lineup.lineup.utils.events.OrgDetails

/**
 * Created by abduakhatov on 1/18/18 at 11:24 PM.
 */
class SeachListAdapter(private val context: Context, private val list: List<Organzatn>)
    : RecyclerView.Adapter<SeachListAdapter.ViewHolder>() {
    private var clicked = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_home_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var org: Organzatn = list.get(position)
        when (org.openClosed) {
            false -> {
                holder.tvOpenClosed.text = Constants.CLOSED
                holder.tvOpenClosed.setTextColor(Color.RED)
            }
            true -> {
                holder.tvOpenClosed.text = Constants.OPEN
                holder.tvOpenClosed.setTextColor(Color.GREEN)
            }

        }
        holder.ivBookmark.setOnClickListener({
            if (clicked) {
                holder.ivBookmark.setImageResource(R.drawable.ic_like)
                RxBus2.publish(RxBus2.ITEM_DELETE, ItemRemove(position, true)) //todo
                notifyItemChanged(position)
                clicked = false
            } else {
                holder.ivBookmark.setImageResource(R.drawable.ic_liked)
                RxBus2.publish(RxBus2.ITEM_DELETE, ItemRemove(position, false)) // todo
                notifyItemChanged(position)
                clicked = true
            }
        })
        holder.tvNameOfOrg.text = org.organization.name
        var peopleCount = org.regOrganization.peopleWaiting
        holder.tvWaitingPeople.text  = peopleCount.toString()
        holder.tvApproximateTime.text = (org.regOrganization.averageWaitingTime * peopleCount!!).toString() + " min"
        holder.tvOpenClosed.text = if (org.openClosed) Constants.OPEN else Constants.CLOSED
        val orgDetails = OrgDetails()
        orgDetails.org = list[position].organization
        orgDetails.regedOrg = list[position].regOrganization
        holder.itemView.setOnClickListener { OrganizationDetailsActivity.start(context as Activity, orgDetails) }
    }
//
//    private fun showPopupMenu(view: View) {
//        // inflate menu
//        val popup = PopupMenu(context, view)
//        val inflater = popup.getMenuInflater()
//        inflater.inflate(R.menu.menu_album, popup.getMenu())
//        popup.setOnMenuItemClickListener(null)
//        popup.show()
//    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvNameOfOrg: TextView
        var tvLocation: TextView
        var tvOpenClosed: TextView
        var ivBookmark: ImageView
        var tvWaitingPeople: TextView
        var tvApproximateTime: TextView

        init {
            tvNameOfOrg = v.findViewById(R.id.tvNameOfOrg)
            tvLocation = v.findViewById(R.id.tvLocation)
            tvOpenClosed = v.findViewById(R.id.tvOpenClosed)
            ivBookmark = v.findViewById(R.id.ivBookmark)
            tvWaitingPeople = v.findViewById(R.id.tvWaitingPeople)
            tvApproximateTime = v.findViewById(R.id.tvApproximateTime)
        }
    }
}