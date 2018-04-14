package uz.wiut.lineup.lineup.ui.home.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import co.revely.gradient.RevelyGradient
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.home.adapter.ActiveListAdapter
import uz.wiut.lineup.lineup.ui.model.Organization
import uz.wiut.lineup.lineup.ui.model.RegisteredOrganization
import uz.wiut.lineup.lineup.utils.Constants

class HomeFragment : Fragment() {

    @BindView(R.id.llGradContainer)
    lateinit var llGradContainer : LinearLayout

    private val data = arrayListOf<RegisteredOrganization>()

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        ButterKnife.bind(this, view)
        var rvActiveQueueList : RecyclerView = view.findViewById(R.id.rvActiveQueueList)
        rvActiveQueueList.visibility = View.VISIBLE
        getData()
        val adapter = ActiveListAdapter(this.context, data)
        val llManager = LinearLayoutManager(this.context)
        val rvSearchList = view.findViewById<View>(R.id.rvActiveQueueList) as RecyclerView
        rvSearchList.layoutManager = llManager
        rvSearchList.adapter = adapter

        initUI()
        return view

    }

    private fun initUI() {
        RevelyGradient.linear()
                .angle(-45f)
                .colors(Constants.arrOfColsBelowToolbar)
                .onBackgroundOf(llGradContainer)

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
