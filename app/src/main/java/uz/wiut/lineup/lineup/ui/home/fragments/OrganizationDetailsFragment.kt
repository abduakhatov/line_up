package uz.wiut.lineup.lineup.ui.home.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.utils.Constants

class OrganizationDetailsFragment : Fragment() {

    @BindView(R.id.tvOfficeStatus)
    lateinit var tvOfficeStatus: TextView
    @BindView(R.id.tvNumberOfPeopleWating)
    lateinit var tvNumberOfPeopleWating: TextView
    @BindView(R.id.tvAverageTime)
    lateinit var tvAverageTime: TextView
    @BindView(R.id.tvApproxTimeLeft)
    lateinit var tvApproxTimeLeft: TextView
    @BindView(R.id.btnGetQueue)
    lateinit var btnGetQueue: Button
    @BindView(R.id.btnDetails)
    lateinit var btnDetails: Button
    @BindView(R.id.llUpperDetails)
    lateinit var llUpperDetails: LinearLayout
    @BindView(R.id.llLowerDetails)
    lateinit var llLowerDetails: LinearLayout


    companion object {
        @JvmStatic
        fun newInstance() = OrganizationDetailsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_organization_details, container, false)
        ButterKnife.bind(this, view)

        tvOfficeStatus.text = "Soon"
        tvNumberOfPeopleWating.text = "Soon"
        tvAverageTime.text = "Soon"
        tvApproxTimeLeft.text = "Soon"

        return view
    }

    @OnClick(R.id.btnDetails)
    internal fun details() {
        Log.d(Constants.DEBUG, "internal fun details()")

//        llUpperDetails.visibility = View.GONE
//        llLowerDetails.visibility = View.VISIBLE
    }
}
