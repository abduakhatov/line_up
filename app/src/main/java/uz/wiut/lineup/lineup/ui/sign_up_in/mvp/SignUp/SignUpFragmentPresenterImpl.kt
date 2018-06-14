package uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignUp

import android.app.Activity
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.database.*
import io.reactivex.functions.Consumer
import uz.wiut.component.utils.RxBus2
import uz.wiut.component.utils.events.Authentification
import uz.wiut.lineup.lineup.model.User
import uz.wiut.lineup.lineup.ui.main.HomeActivity
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Shohruh on 20-Apr-18.
 */
class SignUpFragmentPresenterImpl : SignUpFragmentPresenter, PhoneAuthProvider.OnVerificationStateChangedCallbacks {

    @Inject
    lateinit var view: SignUpFragmentView

    private var mAuth: FirebaseAuth? = null
    private var dbRef: DatabaseReference
    private var dbClients: DatabaseReference
    private var mResendToken: PhoneAuthProvider.ForceResendingToken? = null
    private var authFailed = false
    private var isCalledFromSignInfragment = false
    private lateinit var mVerificationId: String
    private lateinit var activity: Activity
    private lateinit var mName: String
    private var mPhone: String? = null
    private var mPass: String? = null


    @Inject
    constructor() {
        mAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference()
        dbClients = dbRef.child("v1/usersList/clients")
    }

    override fun onSignUpClicked(name: String, phone: String, pass: String, activity: Activity) {
        mName = name.trim()
        mPhone = phone.trim()
        mPass = pass.trim()
        this.activity = activity

        if (mName.length < 1 || mName == null || mName.length < 1 || mName == null || mName.length < 1 || mName == null) {
            view.message("Fields should not be empty")
            return
        }
        sendCode()
        view.showVerification()
    }

    override fun onUserVerificationCalledFromSignInFrgmt(auth: Authentification, activity: Activity) {
        isCalledFromSignInfragment = true
        mPhone = auth.phone
        mPass = auth.password
        this.activity = activity
        view.showVerification()
        sendCode()
    }

    private fun sendCode() {
        mAuth = FirebaseAuth.getInstance()
//        if (uid == null || mAuth == null)
        mAuth?.signOut()
//        var uid = mAuth?.currentUser?.uid

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mPhone!!,                  // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,       // Unit of timeout
                this.activity,          // Activity (for callback binding)
                this
        )
    }

    override fun onVerifyClicked(code: String) {
        if (code.length < 1 || code == null) {
            view.message("Code cannot be empty")
            return
        }
        verifyPhoneNumberWithCode(mVerificationId, code)
        if (authFailed) return
        if (isCalledFromSignInfragment) verifyPassword()
        else pushPassword()

    }

    override fun onVerificationCompleted(credential: PhoneAuthCredential) {
        view.log("onVerificationCompleted:" + credential)
        signInWithPhoneAuthCredential(credential)
    }

    override fun onVerificationFailed(e: FirebaseException?) {
        view.log("onVerificationFailed ${e}")
        authFailed = true
        if (e is FirebaseAuthInvalidCredentialsException) {
            view.log("Invalid request ${e}")
        } else if (e is FirebaseTooManyRequestsException) {
            view.log("he SMS quota for the project has been exceeded ${e}")
        }
    }

    override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken?) {
        super.onCodeSent(verificationId, token)
        view.log("onCodeSent:" + verificationId)
        mVerificationId = verificationId
        mResendToken = token
    }

    private fun verifyPhoneNumberWithCode(verificationId: String, code: String) {
        var credential = PhoneAuthProvider.getCredential(verificationId, code)
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful()) {
                        var user = task.getResult().getUser() as FirebaseUser
                        authFailed = false
                        view.log("signInWithCredential:success")
                        view.log("firebase User2 ${user}")
                    } else {
                        authFailed = true
                        view.log("signInWithCredential:failure ${task.getException()}")
                        view.message("Incorect code")
                    }
                }
    }

    private fun verifyPassword() {
        var currentUser = mAuth?.currentUser?.uid
        dbClients.child("${currentUser}").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (!dataSnapshot.exists()) return
                var user = dataSnapshot.getValue<User>(User::class.java)
                if (user?.password.equals(mPass))
                    view.startActivity(HomeActivity())
                else
                    goBackToSignIn(user)
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    private fun goBackToSignIn(user: User?) {
        view.closeFragment()
        RxBus2.unregister(this)
    }

    private fun pushPassword() {
        var user = User()
        user.isMale = true
        user.phoneNumber = mPhone
        user.name = mName
        user.password = mPass

        var currentUser = mAuth?.currentUser?.uid
        dbClients.child("${currentUser}").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) return
                dbClients.child("${currentUser}").setValue(user)
                view.startActivity(HomeActivity())
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }
}