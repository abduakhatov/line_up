package uz.wiut.lineup.lineup.ui.search.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.DaggerFragment
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.model.Organization
import uz.wiut.lineup.lineup.ui.search.adapter.SeachListAdapter
import uz.wiut.lineup.lineup.ui.search.mvp.city.CitySearchFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.search.mvp.city.CitySearchFragmentView
import javax.inject.Inject

/**
 * Created by abduakhatov on 1/17/18 at 12:46 PM.
 */

class CitySearchFragment : DaggerFragment(), CitySearchFragmentView{

    @Inject
    lateinit var presenter : CitySearchFragmentPresenterImpl

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

    private fun initAdapter() {
        val adapter = SeachListAdapter(this.context, getData())
        val llManager = LinearLayoutManager(this.context)
        rvSearchList.layoutManager = llManager
        rvSearchList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        initAdapter()
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