package uz.wiut.lineup.lineup.ui.message

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.message.adapter.MessageAdapter
import uz.wiut.lineup.lineup.model.toDelete.Message

class MessagesActivity : AppCompatActivity() {

    @BindView(R.id.rvMessagesList)
    lateinit var rvMessagesList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        ButterKnife.bind(this)
        initUI()
        setUpAdapter()
    }

    fun initUI() {
//        rvMessagesList.findViewById<View>(R.id.rvMessagesList) as RecyclerView
    }

    fun setUpAdapter() {
        val adapter = MessageAdapter(this, getData())
        rvMessagesList.layoutManager = LinearLayoutManager(this)
        rvMessagesList.adapter = adapter
    }

    fun getData(): List<Message> {
        var list = ArrayList<Message>()
        list.add(Message("Friend " + 1, "Some message", 1, true))
        list.add(Message("Friend " + 2, "Some message", 2, true))
        list.add(Message("Friend " + 3, "Some message", 3, false))
        list.add(Message("Friend " + 4, "Some message", 4, false))
        list.add(Message("Friend " + 5, "Some message", 5, true))
        list.add(Message("Friend " + 6, "Some message", 6, true))
        list.add(Message("Friend " + 7, "Some message", 7, true))
        list.add(Message("Friend " + 8, "Some message", 8, false))
        list.add(Message("Friend " + 9, "Some message", 9, true))

        return list
    }

}
