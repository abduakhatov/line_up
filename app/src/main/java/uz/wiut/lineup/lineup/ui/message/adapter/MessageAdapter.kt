package uz.wiut.lineup.lineup.ui.message.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.model.Message

/**
 * Created by abduakhatov on 1/19/18 at 11:29 PM.
 */
class MessageAdapter(private val context: Context, private val list: List<Message>)
    : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_messages_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var msg: Message = list.get(position)

        holder?.tvInitials?.text = msg.sender[0].toUpperCase().toString()
        holder?.tvSender?.text = msg.sender
        holder?.tvBody?.text = msg.body
//        holder?.tvTime?.text = msg.
        holder?.tvUnread?.text = list.count { it.isRead }.toString()
    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvInitials: TextView
        var tvSender: TextView
        var tvBody: TextView
        var tvTime: TextView
        var tvUnread: TextView

        init {
            tvInitials = v.findViewById(R.id.tvInitials)
            tvInitials.width = tvInitials.getHeight()
            Log.d("tag***", tvInitials.getHeight().toString() + " -> " + tvInitials.getWidth())
            tvSender = v.findViewById(R.id.tvSender)
            tvBody = v.findViewById(R.id.tvBody)
            tvTime = v.findViewById(R.id.tvTime)
            tvUnread = v.findViewById(R.id.tvUnread)
        }
    }

}