package uz.wiut.lineup.lineup.ui.search.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.model.Organization
import uz.wiut.lineup.lineup.utils.Constants

/**
 * Created by abduakhatov on 1/18/18 at 11:24 PM.
 */
class SeachListAdapter(private val context: Context, private val list: List<Organization>)
    : RecyclerView.Adapter<SeachListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_search_list, parent, false))


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var org: Organization = list.get(position)
        holder?.tvNameOfOrg?.text = org.organization
        holder?.tvLocation?.text = org.location
        holder?.tvDistance?.text = "%.1f".format(org.distance).toString() + " km"
        holder?.tvOpenClosed?.text = if (org.openClosed) Constants.OPEN else Constants.CLOSED
        // TODO set on click listner with pop-up menu
        // holder.overflowImageView.setOnClickListener{showPopupMenu(holder.overflowImageView)};
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
        var tvDistance: TextView
        var tvOpenClosed: TextView

        init {
            tvNameOfOrg = v.findViewById(R.id.tvNameOfOrg)
            tvLocation = v.findViewById(R.id.tvLocation)
            tvDistance = v.findViewById(R.id.tvDistance)
            tvOpenClosed = v.findViewById(R.id.tvOpenClosed)
        }
    }

}