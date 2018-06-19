package uz.wiut.lineup.lineup.ui.organizationDetails.fragments


import android.content.Context
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import dagger.android.support.DaggerFragment
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.organizationDetails.mvp.fragment.OrganizationDetailsFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.organizationDetails.mvp.fragment.OrganizationDetailsFragmentView
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.OrgDetails
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import co.revely.gradient.RevelyGradient
import uz.wiut.component.utils.RxBus2
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization
import uz.wiut.lineup.lineup.ui.common.fragment.BaseFragment


class OrganizationDetailsFragment : BaseFragment(), OrganizationDetailsFragmentView {

    @Inject
    lateinit var presenter : OrganizationDetailsFragmentPresenterImpl

    @BindView(R.id.llGradContainerMain) lateinit var llGradContainerMain: LinearLayout
    @BindView(R.id.tvOrgName) lateinit var tvOrgName: TextView
    @BindView(R.id.cvTopContainer) lateinit var cvTopContainer: CardView
    @BindView(R.id.llWorkingContainer) lateinit var llWorkingContainer: LinearLayout
    @BindView(R.id.tvApproximateTimeTitle2) lateinit var tvApproximateTimeTitle2: TextView
    @BindView(R.id.tvApproximateTime2) lateinit var tvApproximateTime2: TextView
    @BindView(R.id.tvApproximateTime) lateinit var tvApproximateTime: TextView
    @BindView(R.id.tvApproximateTime3) lateinit var tvApproximateTime3: TextView
    @BindView(R.id.tvApproximateTimeTitle3) lateinit var tvApproximateTimeTitle3: TextView
    @BindView(R.id.tvApproximateTimeTitle) lateinit var tvApproximateTimeTitle: TextView
    @BindView(R.id.btnRegister) lateinit var btnRegister: Button
    @BindView(R.id.tvMoreInfor) lateinit var tvMoreInfor: TextView

    private lateinit var orgDetails: OrgDetails

    companion object {
        @JvmStatic
        fun newInstance(orgDetails: OrgDetails) =
                OrganizationDetailsFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(Constants.ORG_DETAIL, orgDetails)
                    }
                }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_organization_details, container, false)
        ButterKnife.bind(this, view)
        init()
        return view
    }

    private fun init() {
        setUpGradientBg()
        getArgument()
        bindData()
    }

    private fun bindData() {
        var org = orgDetails.org!!
        var regOrg = orgDetails.regedOrg!!

        tvOrgName.text = org.name
        tvApproximateTime3.text = regOrg.peopleWaiting.toString()
        tvApproximateTime.text = (regOrg.peopleWaiting * regOrg.averageWaitingTime).toString()

        tvApproximateTime2.text = calculateApproximateTime()
        if (org.isOpen == 0) {
            btnRegister.visibility = View.INVISIBLE
        }
    }

    @OnClick(R.id.btnRegister)
    fun btnRegisterClick(v: View){
        presenter.onRegisterClicked(isNetworkAvailable(), orgDetails)
    }

    private fun setUpGradientBg() {
        RevelyGradient.linear()
                .angle(-45f)
                .colors(Constants.arrOfColsBelowToolbar)
                .onBackgroundOf(llGradContainerMain)
    }

    private fun calculateApproximateTime(): String {
        val now = Calendar.getInstance()
        now.add(Calendar.MINUTE, orgDetails.regedOrg!!.peopleWaiting * orgDetails.regedOrg!!.averageWaitingTime)
        return SimpleDateFormat("hh:mm").format(now.time)
    }

    private fun getArgument() {
        arguments?.let {
            orgDetails = it.getSerializable(Constants.ORG_DETAIL) as OrgDetails
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.getActiveNetworkInfo()
        return activeNetworkInfo != null
    }

    override fun saved() {
        RxBus2.publish(RxBus2.REGISTER_ITEM_ADDED, orgDetails)
        navigator.makeToask(this.context!!, "Saved")
        activity?.finish()
    }
}
