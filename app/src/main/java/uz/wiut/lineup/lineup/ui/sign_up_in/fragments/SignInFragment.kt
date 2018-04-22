package uz.wiut.lineup.lineup.ui.sign_up_in.fragments


import android.animation.ValueAnimator
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import co.revely.gradient.RevelyGradient
import uz.wiut.component.utils.RxBus2
import uz.wiut.component.utils.events.Authentification
import uz.wiut.component.utils.events.ChangeToolbarTitle
import uz.wiut.component.utils.ui.customEditText.CustomEditText
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.common.fragment.BaseFragment
import uz.wiut.lineup.lineup.ui.main.HomeActivity
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn.SignInFragmentView
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.ChangeFragment
import javax.inject.Inject

class SignInFragment : BaseFragment(), SignInFragmentView {

    @Inject
    lateinit var presenter: SignInFragmentPresenterImpl

    @BindView(R.id.llGradContainer) lateinit var llGradContainer: LinearLayout
    @BindView(R.id.btnSignUp) lateinit var btnSignUp: Button
    @BindView(R.id.btnSignIn) lateinit var btnSignIn: Button
    @BindView(R.id.llWorkingContainer) lateinit var llWorkingContainer: LinearLayout
    @BindView(R.id.tvForgotPassBtn) lateinit var tvForgotPassBtn: TextView
    @BindView(R.id.edPhone) lateinit var edPhone: CustomEditText
    @BindView(R.id.edPassword) lateinit var edPassword: CustomEditText


    companion object {
        @JvmStatic
        fun newInstance() = SignInFragment()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false) as View
        ButterKnife.bind(this, view)
        initUI()
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        activity.finish()
    }

    private fun initUI() {
        RxBus2.publish(RxBus2.TOOLBAR_HIDE, ChangeToolbarTitle())
        setUpGradientBackground()
        setETIcons()
    }

    private fun setUpGradientBackground() {
        val valueAnimator = ValueAnimator.ofFloat(100f, 800f)
        valueAnimator.duration = 4000
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.repeatMode = ValueAnimator.REVERSE
        RevelyGradient.linear()
                .colors(Constants.arrOfCols)
                .animate(valueAnimator, { _valueAnimator, _gradientDrawable ->
                    _gradientDrawable.center(_valueAnimator.animatedValue as Float, _valueAnimator.animatedValue as Float)
                })
                .angle(45f)
                .onBackgroundOf(llGradContainer)
        valueAnimator.start()
    }

    private fun setETIcons() {
        edPhone.setIcon(R.drawable.ic_smartphone)
        edPassword.setIcon(R.drawable.ic_key)
        edPassword.passWordInput(true)
    }

    @OnClick(R.id.btnSignIn)
    fun signInClicked() {
        presenter.onSignInClicked(edPhone.getText(), edPassword.getText())
    }

    @OnClick(R.id.btnSignUp)
    fun signUpClicked() {
        presenter.onSignUpClicked()
    }

    @OnClick(R.id.tvForgotPassBtn)
    fun forgotClicked() {
        presenter.onForgotPasswordClicked()
    }

    @OnClick(R.id.tvNotNowBtn)
    fun tvNotNowClicked() {
        presenter.onAnonymousClicked()
    }

    override fun signIn() {
        navigator.startActivityWithTaskClear(this.context, HomeActivity())
    }

    override fun signUp() {
        RxBus2.publish(RxBus2.TOOLBAR_HIDE, ChangeFragment(SignUpFragment.newInstance(Authentification(), true)))
    }

    override fun signInWithCodeVerification(auth: Authentification) {
        RxBus2.publish(RxBus2.TOOLBAR_HIDE, ChangeFragment(SignUpFragment.newInstance(auth, false)))
    }

    override fun forgotPassword() {

    }

    override fun anonymous() {

    }

    override fun log(message: String) {
        Log.d(Constants.DEBUG, "->>>> ${message}")
    }

    override fun message(message: String) {
        navigator.makeToask(context, message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter
    }


}
