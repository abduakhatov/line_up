package uz.wiut.lineup.lineup.ui.home

import android.os.Bundle
import butterknife.ButterKnife
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.home.fragments.OrganizationDetailsFragment
import uz.wiut.lineup.lineup.ui.home.mvp.OrganizationDetailsActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.home.mvp.OrganizationDetailsActivityView
import javax.inject.Inject

class OrganizationDetailsActivity : BaseActivity(), OrganizationDetailsActivityView {

    @Inject
    lateinit var presenter : OrganizationDetailsActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        ButterKnife.bind(this)

//        initUI()

    }

    private fun initUI() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.flMainContent, OrganizationDetailsFragment.newInstance(), "organizationDetailsFragment")
                .commit()
    }


}
