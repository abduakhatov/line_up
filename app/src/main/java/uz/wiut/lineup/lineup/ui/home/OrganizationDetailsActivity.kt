package uz.wiut.lineup.lineup.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.home.fragments.OrganizationDetailsFragment

class OrganizationDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        ButterKnife.bind(this)

        initUI()

    }

    private fun initUI() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.flMainContent, OrganizationDetailsFragment.newInstance(), "organizationDetailsFragment")
                .commit()
    }


}
