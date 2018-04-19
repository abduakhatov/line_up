package uz.wiut.lineup.lineup.ui.sign_up_in.fragments


import android.content.ContentValues.TAG
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import uz.wiut.component.utils.ui.CustomEditText
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.utils.Constants


class SignUpFragment : Fragment() {
    @BindView(R.id.edName)
    lateinit var etName: CustomEditText
    @BindView(R.id.edPhone)
    lateinit var etPhoen: CustomEditText
    @BindView(R.id.edPassword)
    lateinit var etPassword: CustomEditText
//    @BindView(R.id.etVarif)
//    lateinit var etVarif: EditText
    @BindView(R.id.btnSignUp)
    lateinit var btnSignUp: Button
//    @BindView(R.id.btnSignUp)
//    lateinit var btnSignUp: Button

//    @BindView(R.id.btnVerify)
//    lateinit var btnVerify: Button

    private var listener: SignInFragment.OnSignInUpListener? = null
    private var mAuth: FirebaseAuth? = null
    private lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks;
    lateinit var mVerificationId: String
    private var mResendToken : PhoneAuthProvider.ForceResendingToken? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAuth = FirebaseAuth.getInstance();
        arguments?.let {
            listener = it.getSerializable(Constants.SIGN_CLICK_LISTENER) as SignInFragment.OnSignInUpListener
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth!!.currentUser
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_sign_up, container, false) as View
        ButterKnife.bind(this, view)
        etPhoen = view.findViewById<View>(R.id.edPhone) as CustomEditText
        etPassword = view.findViewById<View>(R.id.edPassword) as CustomEditText
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted:" + credential)
                signInWithPhoneAuthCredential(credential);
            }
            override fun onVerificationFailed(e: FirebaseException) {
                Log.w(TAG, "onVerificationFailed", e);
                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    Log.w(TAG, "Invalid request", e);
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    Log.w(TAG, "he SMS quota for the project has been exceeded", e);
                }
            }
            override fun onCodeSent(verificationId:String, token:PhoneAuthProvider.ForceResendingToken) {
                Log.d(TAG, "onCodeSent:" + verificationId);
                mVerificationId = verificationId;
                mResendToken = token;
            }
        }

//        var tMgr = context.applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
//        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//            var mPhoneNumber = tMgr.line1Number
//            etPassword.setText(mPhoneNumber.toString())
//        } else {
//
//        }
//        var hint = HintR
        return view
    }

    @OnClick(R.id.btnSignUp)
    fun signUpClicked() {

//        var phone = etPhoen.text.toString()
//        var pass = etPassword.text.toString()

        //todo uncomment this later, IMPORTANT PART
//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                phone,                  // Phone number to verify
//                60,                  // Timeout duration
//                TimeUnit.SECONDS,       // Unit of timeout
//                this.activity,          // Activity (for callback binding)
//                mCallbacks
//        );
    }

    private fun verifyPhoneNumberWithCode(verificationId:String , code:String ) {
         // [START verify_with_code]
        var credential = PhoneAuthProvider.getCredential(verificationId, code);
        // [END verify_with_code]
        signInWithPhoneAuthCredential(credential);
    }






    private fun signInWithPhoneAuthCredential(credential:PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(activity) { task ->
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            var user = task.getResult().getUser() as FirebaseUser;
                        } else {
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }
                }
    }

    // TODO IMPORTANT
//    @OnClick(R.id.btnVerify)
//    fun veifyClicked() {
//        verifyPhoneNumberWithCode(mVerificationId, etVarif.text.toString());
//    }


    companion object {
        @JvmStatic
        fun newInstance(listnr: SignInFragment.OnSignInUpListener) =
                SignUpFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(Constants.SIGN_CLICK_LISTENER, listnr)
                    }
                }
    }
}
