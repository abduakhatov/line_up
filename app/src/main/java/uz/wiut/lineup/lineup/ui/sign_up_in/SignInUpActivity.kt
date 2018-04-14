package uz.wiut.lineup.lineup.ui.sign_up_in

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View.GONE
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.gms.common.api.GoogleApiClient
import io.reactivex.functions.Consumer
import uz.wiut.component.utils.RxBus2
import uz.wiut.component.utils.events.ChangeToolbarTitle
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.main.MainActivity
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignInFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignUpFragment
import uz.wiut.lineup.lineup.utils.Constants


class SignInUpActivity : AppCompatActivity(), SignInFragment.OnSignInUpListener {

    private val mCredentialsApiClient: GoogleApiClient? = null
    private val RC_HINT = 1000
    internal var tvUpdateResult: TextView? = null
    @BindView(R.id.toolbar)
    public lateinit var toolbar: Toolbar
    @BindView(R.id.tvToolboxTitle)
    public lateinit var tvToolboxTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        initUI()
    }

    override fun onSignInClicked() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onSignUpClicked() {
        changeFragment(SignUpFragment.newInstance(this))
    }

    override fun onForgotPasswordClicked() {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Exception()
    }

    override fun onAnonymousClicked() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun initUI() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        changeFragment(SignInFragment.newInstance(this))

        RxBus2.subscribe(RxBus2.TOOLBAR_HIDE, this, Consumer { o ->
            if (o is ChangeToolbarTitle){
                if (supportFragmentManager.findFragmentById(R.id.flMainContent) is SignInFragment) {
                    tvToolboxTitle.text = "SignUpFragment"
                    toolbar.visibility = GONE


                    Log.d(Constants.DEBUG, "Testing")
                }
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
}
