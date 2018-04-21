package uz.wiut.lineup.lineup.ui.sign_up_in.mvp.SignIn

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import uz.wiut.component.utils.RxBus2
import uz.wiut.component.utils.events.Authentification
import uz.wiut.lineup.lineup.model.User
import javax.inject.Inject


/**
 * Created by Shohruh on 19-Apr-18.
 */
class SignInFragmentPresenterImpl : SignInFragmentPresenter {

    @Inject
    lateinit var view: SignInFragmentView

    private var mAuth: FirebaseAuth?
    private var dbRef: DatabaseReference
    private var dbUsersRef: DatabaseReference
    private lateinit var dbListner: ValueEventListener
    private lateinit var phoneNumber: String
    private lateinit var pass: String

    @Inject
    constructor() {
        mAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference()
        dbUsersRef = dbRef.child("v1/usersList/clients")
    }


    override fun onSignInClicked(phone: String, password: String) {
        phoneNumber = phone.trim()
        pass = password.trim()

        if (phoneNumber.length < 1 || phoneNumber == null || pass.length < 1 || pass == null) {
            view.message("Fields should not be empty")
            return
        }
        authernticate()
    }

    override fun onSignUpClicked() {
        view.signUp()
    }

    override fun onForgotPasswordClicked() {
        view.forgotPassword()
    }

    override fun onAnonymousClicked() {
        view.anonymous()
    }

    private fun navigateToSignUp() {
        view.signUp()
        RxBus2.publish(RxBus2.SIGN_IN, Authentification(phoneNumber, pass))
    }

    private fun authernticate() {
        var uid = mAuth?.currentUser?.uid
        if (uid == null || mAuth == null) navigateToSignUp()

        view.log("uid -> ${uid.toString()}")
        dbUsersRef.child(mAuth?.currentUser?.uid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue<User>(User::class.java)
                view.log("Sign In Fragme db listner - IN")
                if (user == null) return
                if (user.password.equals(pass)) {
                    view.signIn()
                } else {
                    view.message("Invalid password or phone number")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                view.log("The read failed: " + databaseError.code)
                view.message("Failed connecting to server!")
            }
        })
    }
}