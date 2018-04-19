package uz.wiut.lineup.lineup.ui.search

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.search.adapter.SearchVPAdapter
import uz.wiut.lineup.lineup.ui.search.fragments.CategorySearchFragment
import uz.wiut.lineup.lineup.ui.search.fragments.MapSearchFragment
import uz.wiut.lineup.lineup.ui.search.fragments.NameSearchFragment
import uz.wiut.lineup.lineup.ui.main.HomeActivity
import android.support.v4.view.ViewPager.OnPageChangeListener
import android.widget.RelativeLayout
import co.revely.gradient.RevelyGradient
import uz.wiut.lineup.lineup.utils.Constants


class SearchFragment : Fragment() {

    @BindView(R.id.vpSearch)
    lateinit var vpSearch: ViewPager
    @BindView(R.id.tlSearch)
    lateinit var tlSearch: TabLayout
    @BindView(R.id.llWorkingContainer)
    lateinit var llWorkingContainer: RelativeLayout
    @BindView(R.id.llGradContainer)
    lateinit var llGradContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_search, container, false) as View
        ButterKnife.bind(this, view)
        val adapter = SearchVPAdapter(childFragmentManager)

        adapter.addFragment(CategorySearchFragment(), "Category")
        adapter.addFragment(NameSearchFragment(), "Name")
        adapter.addFragment(MapSearchFragment(), "Map")
        vpSearch.adapter = adapter
        tlSearch.setupWithViewPager(vpSearch)
        initUI()
        return view
    }

    private fun initUI() {
        RevelyGradient.linear()
                .angle(-45f)
                .colors(Constants.arrOfColsBelowToolbar)
                .onBackgroundOf(llGradContainer)
    }


    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        rvSearchList.clearOnChildAttachStateChangeListeners()
//        rvSearchList.layoutManager = null
//        rvSearchList.adapter = null
    }

    companion object {
        @JvmStatic
        fun newInstance()  = SearchFragment()
    }
}











