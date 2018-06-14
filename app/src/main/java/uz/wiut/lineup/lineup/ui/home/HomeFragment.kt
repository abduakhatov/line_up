package uz.wiut.lineup.lineup.ui.home


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import co.revely.gradient.RevelyGradient
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization
import uz.wiut.lineup.lineup.ui.common.fragment.BaseFragment
import uz.wiut.lineup.lineup.ui.home.adapter.ActiveListAdapter
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.HomeFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.HomeFragmentView
import uz.wiut.lineup.lineup.ui.organizationDetails.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.OrgDetails
import javax.inject.Inject


class HomeFragment : BaseFragment(), HomeFragmentView {

    @Inject
    lateinit var presenter: HomeFragmentPresenterImpl

    @BindView(R.id.llGradContainer) lateinit var llGradContainer: LinearLayout
    @BindView(R.id.rvActiveQueueList) lateinit var rvActiveQueueList: RecyclerView


    private var organizationsList = arrayListOf<Organization>()
    private var queueList = arrayListOf<RegisteredOrganization>()
    private lateinit var adapter: ActiveListAdapter

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        ButterKnife.bind(this, view)
        var rvActiveQueueList: RecyclerView = view.findViewById(R.id.rvActiveQueueList)
        rvActiveQueueList.visibility = View.VISIBLE
        presenter.subscribeRxBus()
        initUI()
        return view
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    override fun setOrganizationData(organizationsList: ArrayList<Organization>) {
        this.organizationsList = organizationsList
        setUpRecyclerAdapter()
    }

    override fun setQueueData(queueList: ArrayList<RegisteredOrganization>) {
        this.queueList = queueList
//        adapter.notifyDataSetChanged()
        setUpRecyclerAdapter()
    }


    override fun log(message: String) {
        Log.d(Constants.DEBUG, "->>>> ${message}")
    }

    override fun message(message: String) {
        navigator.makeToask(context, message)
    }

    private fun initUI() {
        setUpGradientBg()
        loadData()
        setUpRecyclerAdapter()
    }

    private fun loadData() {
        presenter.onLoadData()
    }

    private fun setUpRecyclerAdapter() {
        adapter = ActiveListAdapter(this.context, organizationsList, queueList)
        val llManager = LinearLayoutManager(this.context)
        rvActiveQueueList.layoutManager = llManager
        rvActiveQueueList.adapter = adapter
    }

    private fun setUpGradientBg() {
        RevelyGradient.linear()
                .angle(-45f)
                .colors(Constants.arrOfColsBelowToolbar)
                .onBackgroundOf(llGradContainer)
    }

    companion object {
        @JvmStatic fun newInstance() = HomeFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroy()
    }

    override fun startActivity(organizationDetailsActivity: OrganizationDetailsActivity, orgDetails: OrgDetails) {
        navigator.startActivityWithBundle(context, organizationDetailsActivity, orgDetails)
//        Intent(context, toCall::class.java)
//        i.putExtra(Constants.ORG_DETAIL, bundle)
//        context.startActivity(i)
    }
}