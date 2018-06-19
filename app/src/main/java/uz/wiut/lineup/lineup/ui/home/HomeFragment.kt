package uz.wiut.lineup.lineup.ui.home


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
import butterknife.OnClick
import co.revely.gradient.RevelyGradient
import uz.wiut.component.utils.RxBus2
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization
import uz.wiut.lineup.lineup.model.toDelete.Organzatn
import uz.wiut.lineup.lineup.ui.common.fragment.BaseFragment
import uz.wiut.lineup.lineup.ui.home.adapter.ActiveListAdapter
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.HomeFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.home.mvp.fragment.HomeFragmentView
import uz.wiut.lineup.lineup.ui.main.HomeActivity
import uz.wiut.lineup.lineup.ui.organizationDetails.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.OrgDetails
import java.util.function.Consumer
import javax.inject.Inject


class HomeFragment : BaseFragment(), HomeFragmentView {

    @Inject
    lateinit var presenter: HomeFragmentPresenterImpl

    @BindView(R.id.llGradContainer) lateinit var llGradContainer: LinearLayout
    @BindView(R.id.rvActiveQueueList) lateinit var rvActiveQueueList: RecyclerView

    private var organizationsList = arrayListOf<Organization>()
    private var queueList = arrayListOf<RegisteredOrganization>()
    private lateinit var adapter: ActiveListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RxBus2.subscribe(RxBus2.REGISTER_ITEM_ADDED, this,
                io.reactivex.functions.Consumer {
                    if (it is OrgDetails) {
                        organizationsList.add(0, it.org!!)
                        queueList.add(0, it.regedOrg!!)
                        adapter.notifyDataSetChanged()
                    }
                })
    }

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
//        adapter.notifyDataSetChanged()
    }

    override fun setOrganizationData(organizationsList: ArrayList<Organization>) {
        this.organizationsList = organizationsList
//        setUpRecyclerAdapter()
    }

    override fun setQueueData(queueList: ArrayList<RegisteredOrganization>) {
        this.queueList = queueList
//        adapter.notifyDataSetChanged()
//        setUpRecyclerAdapter()
    }


    override fun log(message: String) {
        Log.d(Constants.DEBUG, "->>>> ${message}")
    }

    override fun message(message: String) {
        navigator.makeToask(this!!.context!!, message)
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
        val organization = Organization()
        organization.locationTitle = "Tashkent"
        organization.oId = "tasb1"
        organization.address = "Yunusobod 3"
        organization.categoryTitle = "bnk"
        organization.isOpen = 1
        organization.name = "Ipak yo'li"
        organization.website = "ipakyuli.uz"

        val registeredOrganization = RegisteredOrganization()
        registeredOrganization.oId = "tasb1"
        registeredOrganization.peopleWaiting = 1
        registeredOrganization.averageWaitingTime = 5
        registeredOrganization.category = "bnk"
        registeredOrganization.queueId = "dqId1"
        registeredOrganization.timestamp = 1524537859314
        registeredOrganization.location = "Tashkent"

        if (organizationsList.isEmpty()) {
            organizationsList.add(organization)
            queueList.add(registeredOrganization)
        }

        adapter = ActiveListAdapter(this.context!!, organizationsList, queueList)
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

    @OnClick(R.id.btnSignIn2)
    fun clickAddNew() {
        if (activity is HomeActivity) {
            (activity as HomeActivity).openSearchPage()
        }
    }

    override fun startActivity(organizationDetailsActivity: OrganizationDetailsActivity, orgDetails: OrgDetails) {
        navigator.startActivityWithBundle(this.context!!, organizationDetailsActivity, orgDetails)
//        Intent(context, toCall::class.java)
//        i.putExtra(Constants.ORG_DETAIL, bundle)
//        context.startActivity(i)
    }
}
