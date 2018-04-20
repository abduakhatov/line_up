package uz.wiut.lineup.lineup.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.RelativeLayout
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_home.view.*
import uz.wiut.component.utils.ui.ripleEffect.RippleBackground
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.home.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.ui.main.HomeActivity
import uz.wiut.lineup.lineup.ui.sign_up_in.SignInUpActivity

class SplashScreenActivity : BaseActivity() {

    @BindView(R.id.content)
    lateinit var content: RippleBackground

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        ButterKnife.bind(this)

        content.setViewLocation(RelativeLayout.ALIGN_PARENT_RIGHT)
        content.setViewLocation(RelativeLayout.ALIGN_PARENT_BOTTOM)
        content.startRippleAnimation()
        navigator.startActivity(this, SignInUpActivity())
        content.stopRippleAnimation()
        finish()


    }
}

