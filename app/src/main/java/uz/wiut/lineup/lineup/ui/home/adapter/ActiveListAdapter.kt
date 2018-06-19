package uz.wiut.lineup.lineup.ui.home.adapter

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.wiut.component.utils.RxBus2
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.DailyQueue
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization
import uz.wiut.lineup.lineup.ui.common.holder.BaseViewHolder
import uz.wiut.lineup.lineup.ui.organizationDetails.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.ItemRemove
import uz.wiut.lineup.lineup.utils.events.OrgDetails

/**
 * Created by abduakhatov on 2/5/18 at 3:23 PM.
 */
class ActiveListAdapter(private val context: Context,
                        private var organizationsList: ArrayList<Organization>,
                        private var registeredOrganizations: ArrayList<RegisteredOrganization>
) : RecyclerView.Adapter<BaseViewHolder>() {

    private var clicked = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder = BaseViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_list, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        var org: Organization = organizationsList.get(position)
        var regedOrg: RegisteredOrganization = registeredOrganizations.get(position)

        holder.tvLocation.visibility = View.VISIBLE
        holder.tvOpenClosed.visibility = View.VISIBLE
        holder.ivBookmark.visibility = View.VISIBLE
        holder.tvNameOfOrg.visibility = View.VISIBLE
        holder.tvApproximateTime.visibility = View.VISIBLE
        holder.tvWaitingPeople.visibility = View.VISIBLE
        holder.llTitleContainer.visibility = View.VISIBLE

        holder.tvLocation.text = org.locationTitle
        when (org.isOpen) {
            -1 -> {
                holder.tvOpenClosed.text = Constants.CLOSED
                holder.tvOpenClosed.setTextColor(Color.RED)
            }
            0 -> {
                holder.tvOpenClosed.text = Constants.BREAK
                holder.tvOpenClosed.setTextColor(Color.YELLOW)
            }
            1 -> {
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

        holder.tvNameOfOrg.text = org.name
        holder.llHistoryContainer.visibility = View.GONE
        var peopleCount = regedOrg.peopleWaiting + 1
        holder.tvWaitingPeople.text  = peopleCount.toString()
        holder.tvApproximateTime.text = (regedOrg.averageWaitingTime * (peopleCount - 1)!!).toString() + " min"

        holder.cvActiveQueueItem.setOnClickListener({ view ->
            Log.d(Constants.DEBUG, "ActiveList adapter -> " + position)
            RxBus2.publish(RxBus2.ITEM_DELETE, OrgDetails(org, regedOrg))
        })
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val orgDetails = OrgDetails()
                orgDetails.regedOrg = registeredOrganizations.get(position)
                orgDetails.org = organizationsList.get(position)
                OrganizationDetailsActivity.startAlreadyRegistered(context as Activity, orgDetails)
            }
        })
    }

    override fun getItemCount(): Int = organizationsList.size


}