package uz.wiut.lineup.lineup.ui.my_profile.mvp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import uz.wiut.lineup.lineup.model.User
import javax.inject.Inject

/**
 * Created by Shohruh on 20-Apr-18.
 */
class MyProfileFragmentPresenterImpl : MyProfileFragmentPresenter{
    @Inject
    lateinit var view : MyProfileFragmentView

    private var mAuth: FirebaseAuth?
    private var dbRef: DatabaseReference
    private var dbUsersRef: DatabaseReference
    private var uid : String?

    @Inject
    constructor(){
        mAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference()
        dbUsersRef = dbRef.child("v1/usersList/clients")
        uid = mAuth?.currentUser?.uid
    }

    override fun loadData() {

        view.log("uid -> ${uid.toString()}")
        dbUsersRef.child(mAuth?.currentUser?.uid!!).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                view.log("##### My prifile Fragme db listner - IN")
                val user = dataSnapshot.getValue<User>(User::class.java)
                if (user == null) return
                view.setData(user)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                view.log("The read failed: " + databaseError.code)
                view.message("Failed connecting to server!")
            }
        })
    }

    override fun onDataSave(user: User) {
        dbUsersRef.child(uid!!).setValue(user)
        view.hideEdNameContainer()
        view.message("Updated!")
        view.log("Updated!")
    }


}