package uz.wiut.lineup.lineup.ui.sign_up_in

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View.GONE
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.gms.common.api.GoogleApiClient
import io.reactivex.functions.Consumer
import uz.wiut.component.utils.RxBus2
import uz.wiut.component.utils.events.ChangeToolbarTitle
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.main.MainActivity
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignInFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignUpFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.VerificationFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignInUpActivityView
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUpInActivityPresenterImpl
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.ChangeFragment
import javax.inject.Inject


class SignInUpActivity : BaseActivity(), SignInUpActivityView {

    @Inject
    lateinit var presenter: SignUpInActivityPresenterImpl

    @BindView(R.id.toolbar) lateinit var toolbar: Toolbar
    @BindView(R.id.tvToolboxTitle) lateinit var tvToolboxTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        initUI()
    }

    private fun initUI() {
        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        changeFragment(SignInFragment.newInstance())

        RxBus2.subscribe(RxBus2.TOOLBAR_HIDE, this, Consumer { o ->
            if (o is ChangeToolbarTitle) {
                when (supportFragmentManager.findFragmentById(R.id.flMainContent)) {
                    is SignInFragment -> {
                        toolbar.visibility = GONE
                        Log.d(Constants.DEBUG, "Sign In")
                    }
                    is SignUpFragment -> {
                        toolbar.visibility = GONE
                        Log.d(Constants.DEBUG, "Sign Up")
                    }
                    is VerificationFragment -> {
                        toolbar.visibility = GONE
                        Log.d(Constants.DEBUG, "Verifn")
                    }
                }
            } else if (o is ChangeFragment) {
                changeFragment(o.fragment)
            }
        })
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

    override fun onDestroy() {
        super.onDestroy()
        RxBus2.unregister(this)
    }
}
