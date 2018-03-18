package uz.wiut.lineup.lineup.ui.home.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.home.adapter.ActiveListAdapter
import uz.wiut.lineup.lineup.ui.model.Organization
import uz.wiut.lineup.lineup.ui.model.RegisteredOrganization

class HomeFragment : Fragment() {
    private val data = arrayListOf<RegisteredOrganization>()

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        var rvActiveQueueList : RecyclerView = view.findViewById(R.id.rvActiveQueueList)
        rvActiveQueueList.visibility = View.VISIBLE
        getData()
        val adapter = ActiveListAdapter(this.context, data)
        val llManager = LinearLayoutManager(this.context)
        val rvSearchList = view.findViewById<View>(R.id.rvActiveQueueList) as RecyclerView
        rvSearchList.layoutManager = llManager
        rvSearchList.adapter = adapter
        return view

    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    fun getData() {
        for (i in 0..orgs.size - 1) {
            var org = Organization(orgs[i], location[i], distance[i], openClosed[i])
            data.add(RegisteredOrganization(org, 12, 13, 14))
        }
    }

    private val openClosed = booleanArrayOf(true, false, true, false, true, false, true, false)
    private val orgs = arrayOf("Organization One", "Organization Two",
            "Organization Three", "Organization Four", "Organization Five",
            "Organization Six", "Organization Seven", "Organization Eight")
    private val location = arrayOf("Tashkent, Uzbekistan", "Shymkent, Kazakhstan",
            "Tashkent, Uzbekistan", "Tashkent, Uzbekistan",
            "Samarkand, Uzbekistan", "Fergana, Uzbekistan",
            "Namangan, Uzbekistan", "Tashkent, Uzbekistan")
    private val distance = floatArrayOf(1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f)
}
