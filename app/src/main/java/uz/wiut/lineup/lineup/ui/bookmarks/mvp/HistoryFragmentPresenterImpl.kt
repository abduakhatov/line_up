package uz.wiut.lineup.lineup.ui.histories.mvp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import uz.wiut.lineup.lineup.model.History
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.HistoryFragmentPresenter
import uz.wiut.lineup.lineup.ui.bookmarks.mvp.HistoryFragmentView
import javax.inject.Inject

/**
 * Created by Shohruh on 22-Apr-18.
 */
class HistoryFragmentPresenterImpl : HistoryFragmentPresenter {

    @Inject
    lateinit var view : HistoryFragmentView

    private var mAuth: FirebaseAuth?
    private var dbRef: DatabaseReference
    private var dbHistoryRef: DatabaseReference
    private var dbOrganizationRef: DatabaseReference
    private var uid: String?

    private var histories = ArrayList<History>()
    private var orgs = ArrayList<Organization>()

    @Inject
    constructor(){
        mAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference()
        dbHistoryRef = dbRef.child("v1/histories")
        dbOrganizationRef = dbRef.child("v1/organization")
        uid = mAuth?.currentUser?.uid
    }

    override fun onLoadData() {
        loadHistoryData()
    }

    private fun loadHistoryData() {
        dbHistoryRef.child(uid).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (!dataSnapshot.hasChildren()) return
                histories.clear()
                for (postSnapshot in dataSnapshot.children) {
                    var data = dataSnapshot.child(postSnapshot.key).getValue<History>(History::class.java)
                    data?.historyId = postSnapshot.key
                    histories.add(data!!)
                }
                loadOrganizationData()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                view.log("dbHistoryRef - The read failed: " + databaseError.code)
                view.message("Failed connecting to server!")
            }
        })

    }

    private fun loadOrganizationData() {
        orgs.clear()
        var count = histories.count() -1
        for (j in 0 .. count) {
            var i = histories[j]
            dbOrganizationRef.child("${i.location}/${i.category}/${i.oId}").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    view.log("dbOrganizationRef - IN")
                    if (!dataSnapshot.hasChildren()) return
                    orgs.add(dataSnapshot.getValue<Organization>(Organization::class.java)!!)
                    if (j == count) {
                        view.setBookmarkData(histories)
                        view.setOrganizationData(orgs)

                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    view.log("dbHistoryRef - The read failed: " + databaseError.code)
                    view.message("Failed connecting to server!")
                    return
                }
            })

        }

//        loadQueueData()

    }
}