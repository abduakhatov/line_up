package uz.wiut.lineup.lineup.ui.home.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.home.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.ui.model.RegisteredOrganization
import uz.wiut.lineup.lineup.utils.Constants

/**
 * Created by abduakhatov on 2/5/18 at 3:23 PM.
 */
class ActiveListAdapter(private val context: Context, private val list: List<RegisteredOrganization>)
    : RecyclerView.Adapter<ActiveListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_home_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var org: RegisteredOrganization = list.get(position)
        var organization = org.organization

//        holder?.tvNameOfOrg?.text = organization.organization
//        holder?.tvLocation?.text = organization.location
//        holder?.tvDistance?.text = "%.1f".format(organization.distance).toString() + " km"
//        holder?.tvOpenClosed?.text = if (organization.openClosed) Constants.OPEN else Constants.CLOSED
//
//        holder?.tvNumOnQueueValue?.text = org.numberOnQueue.toString()
//        holder?.tvWaitingTime?.text = org.waitingTime.toString()
//        holder?.tvApproximateTimeValue?.text = org.approximateTime.toString()
//
//        holder!!.cvActiveQueueItem.setOnClickListener({ view ->
//            Log.d("*******", "ActiveList adapter -> " + position)
//            //context.startActivity(Intent(context, OrganizationDetailsActivity::class.java))
//        })

        // TODO set on click listner with pop-up menu
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
//        var tvNameOfOrg: TextView
//        var tvLocation: TextView
//        var tvDistance: TextView
//        var tvOpenClosed: TextView
//
//        var tvNumOnQueueValue: TextView
//        var tvWaitingTime: TextView
//        var tvApproximateTimeValue: TextView
//        var cvActiveQueueItem: CardView

        init {
//            tvNameOfOrg = v.findViewById(R.id.tvNameOfOrg)
//            tvLocation = v.findViewById(R.id.tvLocation)
//            tvDistance = v.findViewById(R.id.tvDistance)
//            tvOpenClosed = v.findViewById(R.id.tvOpenClosed)
//
//            tvNumOnQueueValue = v.findViewById(R.id.tvNumOnQueueValue)
//            tvWaitingTime = v.findViewById(R.id.tvWaitingTime)
//            tvApproximateTimeValue = v.findViewById(R.id.tvApproximateTimeValue)
//            cvActiveQueueItem = v.findViewById(R.id.cvActiveQueueItem)
        }


//        cvActiveQueueItem
//        tvLocation
//        tvOpenClosed
//        ivBookmark
//        tvNameOfOrg
//        tvApproximateTimeTitle
//        tvWaitingTime
    }
}