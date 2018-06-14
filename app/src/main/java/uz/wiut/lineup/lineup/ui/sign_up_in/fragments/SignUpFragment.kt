package uz.wiut.lineup.lineup.ui.sign_up_in.fragments


import android.os.Bundle
import android.text.InputType
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
import co.revely.gradient.RevelyGradient
import uz.wiut.component.utils.events.Authentification
import uz.wiut.component.utils.ui.customEditText.CustomEditText
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.common.fragment.BaseFragment
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp.SignUpFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp.SignUpFragmentView
import uz.wiut.lineup.lineup.utils.Constants
import javax.inject.Inject


class SignUpFragment : BaseFragment(), SignUpFragmentView {

    @Inject
    lateinit var presenter: SignUpFragmentPresenterImpl

    @BindView(R.id.edName)lateinit var edName: CustomEditText
    @BindView(R.id.edPhone)lateinit var edPhone: CustomEditText
    @BindView(R.id.edPassword)lateinit var edPassword: CustomEditText
    @BindView(R.id.btnSignUp)lateinit var btnSignUp: Button
    @BindView(R.id.llGradContainer) lateinit var  llGradContainer : LinearLayout
    @BindView(R.id.llWorkingContainer) lateinit var  llWorkingContainer : LinearLayout
    @BindView(R.id.tvSignInBtn) lateinit var  tvSignInBtn : TextView
    @BindView(R.id.edVerify) lateinit var  edVerify : CustomEditText
    @BindView(R.id.llThreeEDContainer) lateinit var  llThreeEDContainer : LinearLayout
    @BindView(R.id.btnVerify) lateinit var  btnVeify : Button

    private var isForSignUp : Boolean = false
    private lateinit var auth : Authentification

    companion object {
        @JvmStatic
        fun newInstance(authentification: Authentification, isForSignUp: Boolean) =
                SignUpFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(Constants.AUTH, authentification)
                        putSerializable(Constants.IS_FOR_SIGN_UP, isForSignUp)
                    }
                }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isForSignUp = it.getSerializable(Constants.IS_FOR_SIGN_UP) as Boolean
            auth = it.getSerializable(Constants.AUTH) as Authentification
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false) as View
        ButterKnife.bind(this, view)
        initUI()
        return view
    }

    private fun initUI() {
        setUpGradientBg()
        setETIcons()

        if (!isForSignUp) presenter.onUserVerificationCalledFromSignInFrgmt(auth, activity!!)
    }

    private fun setUpGradientBg() {
        RevelyGradient.linear()
                .colors(Constants.arrOfCols)
                .angle(45f)
                .onBackgroundOf(llGradContainer)
    }

    private fun setETIcons() {
        edName.setIcon(R.drawable.ic_user_no_cicle)
        edPhone.setIcon(R.drawable.ic_smartphone)
        edPassword.setIcon(R.drawable.ic_locked)
        edPassword.passWordInput(true)
        edVerify.setIcon(R.drawable.ic_key)
    }

    @OnClick(R.id.tvSignInBtn)
    fun signInBtnClicked() {
        closeFragment()
    }

    @OnClick(R.id.btnSignUp)
    fun signUpClicked() {
        var name = edName.getText()
        var phone = edPhone.getText()
        var pass = edPassword.text.toString()

        presenter.onSignUpClicked(name, phone, pass, activity!!)
    }

    @OnClick(R.id.btnVerify)
    fun verifyClicked() {
        presenter.onVerifyClicked(edVerify.getText())
    }

    override fun message(message: String) {
        navigator.makeToask(context!!, message)
    }

    override fun log(message: String) {
        Log.d(Constants.DEBUG, "->>>> ${message}")
    }

    override fun showVerification() {
        btnSignUp.visibility = View.GONE
        llThreeEDContainer.visibility = View.GONE
        edVerify.visibility = View.VISIBLE
        btnVeify.visibility = View.VISIBLE
    }

    override fun hideVerification() {
        btnSignUp.visibility = View.VISIBLE
        llThreeEDContainer.visibility = View.VISIBLE
        edVerify.visibility = View.GONE
        btnVeify.visibility = View.GONE
    }

    override fun startActivity(activity: BaseActivity) {
        navigator.startActivityWithTaskClear(context, activity)
    }

    override fun closeFragment() {
        navigator.closeFragment(activity)
    }


}
