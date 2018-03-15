package uz.wiut.lineup.lineup.ui.sign_up_in

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import uz.wiut.lineup.lineup.ui.main.MainActivity
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignInFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignUpFragment


class SignInUpActivity : AppCompatActivity(), SignInFragment.OnSignInUpListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
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
        changeFragment(SignInFragment.newInstance(this))
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