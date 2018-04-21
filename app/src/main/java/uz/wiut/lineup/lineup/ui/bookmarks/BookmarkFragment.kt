package uz.wiut.lineup.lineup.ui.bookmarks


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import butterknife.BindView
import butterknife.ButterKnife
import co.revely.gradient.RevelyGradient
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.bookmarks.fragments.HistoryOfBookmarksFragment
import uz.wiut.lineup.lineup.ui.bookmarks.fragments.SavedBookmarkFragment
import uz.wiut.lineup.lineup.ui.search.adapter.SearchVPAdapter
import uz.wiut.lineup.lineup.utils.Constants

class BookmarkFragment : Fragment() {

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
        setUpView()
        val adapter = SearchVPAdapter(childFragmentManager)
        adapter.addFragment(SavedBookmarkFragment(), "Saved")
        adapter.addFragment(HistoryOfBookmarksFragment(), "History")
        vpSearch.adapter = adapter
        tlSearch.setupWithViewPager(vpSearch)

        return view
    }

    private fun setUpView() {
        RevelyGradient.linear()
                .angle(-45f)
                .colors(Constants.arrOfColsBelowToolbar)
                .onBackgroundOf(llGradContainer)
        llWorkingContainer.visibility = ViewGroup.GONE
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = BookmarkFragment()
    }

}
