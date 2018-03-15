package uz.wiut.lineup.lineup.ui.sign_up_in.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.utils.Constants
import java.io.Serializable

class SignInFragment : Fragment() {

    @BindView(R.id.tvPhone)
    lateinit var tvPhone: TextView
    @BindView(R.id.edPhone)
    lateinit var edPhone: EditText
    @BindView(R.id.tvPassword)
    lateinit var tvPassword: TextView
    @BindView(R.id.edPassword)
    lateinit var edPassword: EditText
    @BindView(R.id.btnForgot)
    lateinit var btnForgot: Button
    @BindView(R.id.btnSignUp)
    lateinit var btnSignUp: Button
    @BindView(R.id.btnAnonymous)
    lateinit var btnAnonymous: Button
    @BindView(R.id.btnSignIn)
    lateinit var btnSignIn: Button

    private var listener: OnSignInUpListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listener = it.getSerializable(Constants.SIGN_CLICK_LISTENER) as OnSignInUpListener
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sign_in, container, false) as View
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(R.id.btnSignUp)
    fun signUpClicked() {
        listener!!.onSignUpClicked()
    }

    @OnClick(R.id.btnAnonymous)
    fun anonymousClicked() {
        listener!!.onAnonymousClicked()
    }

    @OnClick(R.id.btnSignIn)
    fun signInClicked() {
        listener!!.onSignInClicked()
    }


    interface OnSignInUpListener : Serializable {
        fun onSignInClicked()
        fun onSignUpClicked()
        fun onForgotPasswordClicked()
        fun onAnonymousClicked()
    }

    companion object {
        @JvmStatic
        fun newInstance(listnr: OnSignInUpListener) =
                SignInFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(Constants.SIGN_CLICK_LISTENER, listnr)
                    }
                }
    }
}
