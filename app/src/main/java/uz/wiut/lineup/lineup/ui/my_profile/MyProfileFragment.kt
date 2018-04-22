package uz.wiut.lineup.lineup.ui.my_profile

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_sign_in.*
import uz.wiut.component.utils.ui.customEditText.CustomEditText
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.model.User
import uz.wiut.lineup.lineup.ui.common.fragment.BaseFragment
import uz.wiut.lineup.lineup.ui.my_profile.mvp.MyProfileFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.my_profile.mvp.MyProfileFragmentView
import uz.wiut.lineup.lineup.utils.Constants
import javax.inject.Inject

class MyProfileFragment : BaseFragment(), MyProfileFragmentView {

    @Inject
    lateinit var presenter: MyProfileFragmentPresenterImpl

    @BindView(R.id.vAvatar) lateinit var vAvatar: View
    @BindView(R.id.tvName) lateinit var tvName: TextView
    @BindView(R.id.imEdit) lateinit var imEdit: ImageView
    @BindView(R.id.edPhone) lateinit var edPhone: CustomEditText
    @BindView(R.id.edPassword) lateinit var edPassword: CustomEditText
    @BindView(R.id.edName) lateinit var edName: CustomEditText
    @BindView(R.id.btnSave) lateinit var btnSave: Button
    @BindView(R.id.swIsMale) lateinit var swIsFemale: Switch
    @BindView(R.id.rlTvNameContainer) lateinit var rlTvNameContainer: RelativeLayout

    private var user: User = User()

    companion object {
        @JvmStatic
        fun newInstance() = MyProfileFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_profile, container, false) as View
        ButterKnife.bind(this, view)
        initUI()
        return view
    }

    private fun initUI() {
        edPhone.disableEditTextInput()
        edPassword.passWordInput(true)
        loadData()
    }

    private fun loadData() {
        presenter.loadData()
    }

    private fun bindData() {
        changeGender()
        tvName.text = user.name
        edPassword.text = user.password
        edPhone.text = user.phoneNumber

    }

    private fun changeGender() {
        if (user.isMale) {
            vAvatar.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_man))
            swIsFemale.isChecked = false
            swIsFemale.text = "Male"
        } else {
            vAvatar.setBackground(ContextCompat.getDrawable(context, R.drawable.ic_woman))
            swIsFemale.isChecked = true
            swIsFemale.text = "Female"
        }
    }

    private fun getChanges(){
        user.isMale = !swIsFemale.isChecked
        if(edName.visibility == View.VISIBLE) user.name = edName.getText()
        user.password = edPassword.getText()

    }

    override fun setData(user: User) {
        this.user = user
        bindData()
    }

    override fun log(message: String) {
        Log.d(Constants.DEBUG, "->>>> ${message}")
    }

    override fun message(message: String) {
        navigator.makeToask(context, message)
    }

    override fun hideEdNameContainer() {
        rlTvNameContainer.visibility = View.VISIBLE
        edName.visibility = View.GONE
        tvName.text = user.name
    }



    @OnClick(R.id.imEdit)
    fun onEditClick(){
        rlTvNameContainer.visibility = View.GONE
        edName.visibility = View.VISIBLE
        edName.setText(user.name)
    }

    @OnClick(R.id.btnSave)
    fun onSaveClick(){
        getChanges()
        presenter.onDataSave(user)
    }
}
