package uz.wiut.lineup.lineup.ui.organizationDetails

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.reactivex.functions.Consumer
import uz.wiut.component.utils.RxBus2
import uz.wiut.component.utils.events.ChangeToolbarTitle
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.organizationDetails.fragments.MoreDetailsFragment
import uz.wiut.lineup.lineup.ui.organizationDetails.fragments.OrganizationDetailsFragment
import uz.wiut.lineup.lineup.ui.organizationDetails.mvp.OrganizationDetailsActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.organizationDetails.mvp.OrganizationDetailsActivityView
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignInFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignUpFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.VerificationFragment
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.ChangeFragment
import uz.wiut.lineup.lineup.utils.events.OrgDetails
import javax.inject.Inject
import android.support.v4.app.NotificationCompat.getExtras



class OrganizationDetailsActivity : BaseActivity(), OrganizationDetailsActivityView {

    @Inject
    lateinit var presenter : OrganizationDetailsActivityPresenterImpl

    @BindView(R.id.toolbar) lateinit var toolbar: Toolbar
    @BindView(R.id.tvToolboxTitle) lateinit var tvToolboxTitle: TextView

    private var orgDetails = OrgDetails()

    companion object {
        fun start(activity: Activity){
            val intent = Intent(activity, OrganizationDetailsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        initUI()

    }

    private fun initUI() {
        loadDataFromBundle()
        changeFragment(OrganizationDetailsFragment.newInstance(orgDetails))
        rxBusRegister()
    }

    private fun loadDataFromBundle() {
        val extras = intent.extras
        if (extras != null) {
            orgDetails = intent.getSerializableExtra(Constants.ORG_DETAIL) as OrgDetails
        }
    }

    private fun changeFragment(fragment: Fragment) {
        if (fragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .addToBackStack(this.localClassName)
                    .replace(R.id.flMainContent, fragment)
                    .commit()
        }
    }

    private fun rxBusRegister() {
        RxBus2.subscribe(RxBus2.TOOLBAR_HIDE, this, Consumer { o ->
            if (o is ChangeToolbarTitle) {
                when (supportFragmentManager.findFragmentById(R.id.flMainContent)) {
                    is OrganizationDetailsFragment -> {
                        toolbar.visibility = View.GONE
                        Log.d(Constants.DEBUG, "Queue Details")
                        tvToolboxTitle.text = "Queue Details"
                    }
                    is MoreDetailsFragment -> {
                        toolbar.visibility = View.GONE
                        Log.d(Constants.DEBUG, "Details")
                        tvToolboxTitle.text = "Details"
                    }
                }
            } else if (o is ChangeFragment) {
                changeFragment(o.fragment)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus2.unregister(this)
    }

}
