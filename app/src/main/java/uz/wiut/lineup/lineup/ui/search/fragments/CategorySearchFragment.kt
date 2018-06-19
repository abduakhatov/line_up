package uz.wiut.lineup.lineup.ui.search.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.DaggerFragment
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization
import uz.wiut.lineup.lineup.model.toDelete.Organzatn
import uz.wiut.lineup.lineup.ui.search.adapter.SeachListAdapter
import uz.wiut.lineup.lineup.ui.search.mvp.category.CategorySearchFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.search.mvp.category.CategorySearchFragmentView
import javax.inject.Inject

/**
 * Created by abduakhatov on 1/17/18 at 6:41 PM.
 */
class CategorySearchFragment : DaggerFragment(), CategorySearchFragmentView {

    @Inject
    lateinit var presenter: CategorySearchFragmentPresenterImpl

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

    override fun onDestroyView() {
        super.onDestroyView()
        rvSearchList.clearOnChildAttachStateChangeListeners()
        rvSearchList.layoutManager = null
        rvSearchList.adapter = null
    }

    private fun initAdapter() {
        val organzatns = arrayListOf<Organzatn>()
        data.clear()
        dataRegisteredOrganizations.clear()
        data = getData()
        dataRegisteredOrganizations = getDataRegisterOrganizations()
        for (i in 0..data.size - 1) {
            val organzatn = Organzatn(data[i], dataRegisteredOrganizations[i],
                    location[i], distance[i], openClosed[i])
            organzatns.add(organzatn)
        }
        val adapter = SeachListAdapter(this.context!!, organzatns)
        val llManager = LinearLayoutManager(this.context)
        rvSearchList.layoutManager = llManager
        rvSearchList.adapter = adapter
    }

    private var data = arrayListOf<Organization>()
    private var dataRegisteredOrganizations = arrayListOf<RegisteredOrganization>()

    fun getData(): ArrayList<Organization> {
        for (i in 0..orgs.size - 1) {
            val organization = Organization()
            organization.name = orgs[i]
            organization.address = location[i]
            data.add(organization)
        }
        return data
    }

    fun getDataRegisterOrganizations(): ArrayList<RegisteredOrganization> {
        for (i in 0..orgs.size - 1) {
            val registeredOrganization = RegisteredOrganization()
            registeredOrganization.averageWaitingTime = everageWaitingTimes[i]
            registeredOrganization.peopleWaiting = queue[i]
            dataRegisteredOrganizations.add(registeredOrganization)
        }
        return dataRegisteredOrganizations
    }

    private val openClosed = booleanArrayOf(true, false, true, true, false, false, true, false)
    private val orgs = arrayOf("Buyuk ipak yuli", "Trans Bank",
            "Mikrokredit Bank", "Paxta Bank", "Milliy Bank",
            "Xalq Bank", "Ipoteka Bank", "Hamkor Bank")
    private val location = arrayOf("Tashkent, Yunusobod, Uzbekistan", "Tashkent, Chilonzor, Uzbekistan",
            "Tashkent, Shayhontoxur Uzbekistan", "Tashkent, Mirzo Ulug'bek Uzbekistan",
            "Tashkent, Yashinobod Uzbekistan", "Tashkent, Yunusobod Uzbekistan",
            "Tashkent, Yakkasaroy Uzbekistan", "Tashkent, Yunusobod Uzbekistan")
    private val queue = arrayOf(3, 5, 2, 0, 8, 4, 0, 6)
    private val everageWaitingTimes = arrayOf(3, 5, 2, 0, 8, 4, 0, 6)
    private val distance = floatArrayOf(1f, 5f, 2f, 6f, 5f, 6f, 7f, 8f)
}