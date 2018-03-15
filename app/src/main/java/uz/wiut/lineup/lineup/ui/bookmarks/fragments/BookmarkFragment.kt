package uz.wiut.lineup.lineup.ui.bookmarks.fragments


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.search.adapter.SearchVPAdapter

class BookmarkFragment : Fragment() {

    @BindView(R.id.vpSearch)
    lateinit var vpSearch: ViewPager
    @BindView(R.id.tlSearch)
    lateinit var tlSearch: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_search, container, false) as View
        ButterKnife.bind(this, view)
        val adapter = SearchVPAdapter(fragmentManager)
        adapter.addFragment(SavedBookmarkFragment(), "Saved")
        adapter.addFragment(HistoryOfBookmarksFragment(), "History")
        vpSearch.adapter = adapter
        tlSearch.setupWithViewPager(vpSearch)

        return view
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = BookmarkFragment()
    }

}
