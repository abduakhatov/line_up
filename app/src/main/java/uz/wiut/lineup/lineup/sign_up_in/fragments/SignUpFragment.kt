package uz.wiut.lineup.lineup.sign_up_in.fragments


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


class SignUpFragment : Fragment() {
    @BindView(R.id.tvName)
    lateinit var tvName: TextView
    @BindView(R.id.edName)
    lateinit var edName: EditText
    @BindView(R.id.tvPhone)
    lateinit var tvPhone: TextView
    @BindView(R.id.edPhoen)
    lateinit var edPhoen: EditText
    @BindView(R.id.tvPassword)
    lateinit var tvPassword: TextView
    @BindView(R.id.edPassword)
    lateinit var edPassword: EditText
    @BindView(R.id.btnSignUp)
    lateinit var btnSignUp: Button

    private var listener: SignInFragment.OnSignInUpListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listener = it.getSerializable(Constants.SIGN_CLICK_LISTENER) as SignInFragment.OnSignInUpListener
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sign_up, container, false) as View
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(R.id.btnSignUp)
    private fun signUpClicked() {
        listener!!.onSignUpClicked()
    }

    companion object {
        @JvmStatic
        fun newInstance(listnr: SignInFragment.OnSignInUpListener) =
                SignInFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(Constants.SIGN_CLICK_LISTENER, listnr)
                    }
                }
    }
}
