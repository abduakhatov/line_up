package uz.wiut.lineup.lineup.ui.bookmarks.mvp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import io.reactivex.functions.Consumer
import uz.wiut.component.utils.RxBus2
import uz.wiut.lineup.lineup.model.Bookmark
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.ItemRemove
import javax.inject.Inject

/**
 * Created by Shohruh on 22-Apr-18.
 */
class SavedFragmentPresenterImpl : SavedFragmentPresenter {

    @Inject
    lateinit var view: SavedFragmentView

    private var mAuth: FirebaseAuth?
    private var dbRef: DatabaseReference
    private var dbBookmarkRef: DatabaseReference
    private var dbOrganizationRef: DatabaseReference
    private var dbQueueRef: DatabaseReference
    private var uid: String?


    private var bookmarks = ArrayList<Bookmark>()
    private var orgs = ArrayList<Organization>()
    private var queues = ArrayList<Bookmark>()

    @Inject
    constructor() {
        mAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference()
        dbBookmarkRef = dbRef.child("v1/bookmarks")
        dbOrganizationRef = dbRef.child("v1/organization")
        dbQueueRef = dbRef.child("v1/dailyQueues")
        uid = mAuth?.currentUser?.uid
    }


    override fun onLoadData() {
        loadBookMarkData()
//        loadOrganizationData()
    }


    private fun loadBookMarkData() {
        dbBookmarkRef.child(uid!!).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (!dataSnapshot.hasChildren()) return
                bookmarks.clear()
                for (postSnapshot in dataSnapshot.children) {
                    var data = dataSnapshot.child(postSnapshot.key!!).getValue<Bookmark>(Bookmark::class.java)
                    data?.bookmarkId = postSnapshot.key
                    bookmarks.add(data!!)
                }
                loadOrganizationData()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                view.log("dbBookmarkRef - The read failed: " + databaseError.code)
                view.message("Failed connecting to server!")
            }
        })

    }

    private fun loadOrganizationData() {
        orgs.clear()
        var count = bookmarks.count() - 1
        for (j in 0..count) {
            var i = bookmarks[j]
            dbOrganizationRef.child("${i.location}/${i.category}/${i.oId}").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    view.log("dbOrganizationRef - IN")
                    if (!dataSnapshot.hasChildren()) return
                    orgs.add(dataSnapshot.getValue<Organization>(Organization::class.java)!!)
                    if (j == count)
                        view.setOrganizationData(orgs)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    view.log("dbBookmarkRef - The read failed: " + databaseError.code)
                    view.message("Failed connecting to server!")
                    return
                }
            })

        }

//        loadQueueData()

    }

    private fun loadQueueData() {
        var todayL = Constants.getTimestamp()
    }

    fun removeItemFromDb(postion: Int) {
        if (bookmarks.size > postion) {
            dbBookmarkRef.child(uid!!).child(bookmarks[postion].bookmarkId!!).removeValue()
            view.log("******item removed")
        }
    }

    override fun onDestroy() {
        RxBus2.unregister(this)
    }

    override fun subscribeRxBus() {
        RxBus2.subscribe(RxBus2.ITEM_DELETE, this, Consumer { o ->
            if (o is ItemRemove) {
                if ((o as ItemRemove).isToRemove) removeItemFromDb(o.postion)
            }
        })
    }
}