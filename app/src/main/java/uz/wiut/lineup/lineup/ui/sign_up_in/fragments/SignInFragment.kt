package uz.wiut.lineup.lineup.ui.sign_up_in.fragments


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.telephony.TelephonyManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.firebase.auth.FirebaseAuth
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.utils.Constants
import java.io.Serializable

class SignInFragment : Fragment(){

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
    private lateinit var mAuth: FirebaseAuth
    var wantPermission = Manifest.permission.READ_PHONE_STATE
    private val PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance();
        val currentUser = mAuth.currentUser
        Log.d(Constants.DEBUG, "${currentUser.toString()} -- > ${currentUser} --> $currentUser");

        arguments?.let {
            listener = it.getSerializable(Constants.SIGN_CLICK_LISTENER) as OnSignInUpListener
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sign_in, container, false) as View
        ButterKnife.bind(this, view)
        initUI()
        return view
    }


    private fun initUI() {
        if (!checkPermission(wantPermission)) {
            requestPermission(wantPermission);
        } else {
            Log.d(Constants.DEBUG, "Phone number: " + getPhone());
        }
    }

    private fun getPhone(): String {
//        val phoneMgr = activity.applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val phoneMgr = this.activity.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (ActivityCompat.checkSelfPermission(activity, wantPermission) != PackageManager.PERMISSION_GRANTED) {
            ""
        } else {
            Log.d(Constants.DEBUG, "tm.deviceId --> " + phoneMgr.deviceId)
            Log.d(Constants.DEBUG, "tm.simSerialNumber --> " + phoneMgr.simSerialNumber)
        }
        return "above data"
    }

    private fun requestPermission(permission: String) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
            Toast.makeText(activity, "Phone state permission allows us to get phone number. Please allow it for additional functionality.", Toast.LENGTH_LONG).show()
        }
        ActivityCompat.requestPermissions(activity, arrayOf(permission), PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE){
            if (grantResults.count() > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(Constants.DEBUG, "Phone number: " + getPhone());
            } else {
                Toast.makeText(activity,"Permission Denied. We can't get phone number.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private fun checkPermission(permission:String) : Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            var result = ContextCompat.checkSelfPermission(activity, permission);
            if (result == PackageManager.PERMISSION_GRANTED){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
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
