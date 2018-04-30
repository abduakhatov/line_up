package uz.wiut.lineup.lineup.ui.bookmarks.fragments


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.Bookmark
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.ui.bookmarks.adapter.SavedFragmentAdapter
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.SavedFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.SavedFragmentView
import uz.wiut.lineup.lineup.ui.common.fragment.BaseFragment
import uz.wiut.lineup.lineup.utils.Constants
import javax.inject.Inject


class SavedBookmarkFragment : BaseFragment(), SavedFragmentView {

    @Inject
    lateinit var presenter: SavedFragmentPresenterImpl

    @BindView(R.id.rvSearchList)
    lateinit var rvSearchList: RecyclerView

    private var organzationsList = arrayListOf<Organization>()
    private var bookmarkList = arrayListOf<Bookmark>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search_category, container, false)
        ButterKnife.bind(this, view)
        initUI()
        presenter.subscribeRxBus()
        return view
    }

    private fun initUI() {
        loadData()
        initAdapter()
    }

    private fun loadData() {
        presenter.onLoadData()
    }

    override fun onResume() {
        super.onResume()
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = SavedFragmentAdapter(this.context, organzationsList, bookmarkList)
        rvSearchList.layoutManager = LinearLayoutManager(this.context)
        rvSearchList.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun setBookmarkData(bookmarkList: ArrayList<Bookmark>) {
        this.bookmarkList = bookmarkList
    }

    override fun setOrganizationData(organization: ArrayList<Organization>) {
        organzationsList = organization
        initAdapter()
    }

    override fun log(message: String) {
        Log.d(Constants.DEBUG, "->>>> ${message}")
    }

    override fun message(message: String) {
        navigator.makeToask(context, message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroy()
    }
}
