package uz.wiut.lineup.lineup.search.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.search.adapter.SeachListAdapter

/**
 * Created by abduakhatov on 1/17/18 at 6:41 PM.
 */
class CategorySearchFragment : Fragment() {

    @BindView(R.id.rvSearchList)
    lateinit var rvSearchList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search_category, container, false)
        ButterKnife.bind(this, view)

        initAdapter()
        return view
    }

    override fun onResume() {
        super.onResume()
        initAdapter()
    }


    private fun initAdapter() {
        val adapter = SeachListAdapter(this.context, getData())
        val llManager = LinearLayoutManager(this.context)
        rvSearchList.layoutManager = llManager
        rvSearchList.adapter = adapter
    }

    private val data = arrayListOf<Organization>()

    fun getData(): ArrayList<Organization> {
        for (i in 0..orgs.size - 1) {
            data.add(Organization(orgs[i], location[i], distance[i], openClosed[i]))
        }
        return data
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