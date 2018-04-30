package uz.wiut.lineup.lineup.ui.home.mvp.fragment

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import io.reactivex.functions.Consumer
import uz.wiut.component.utils.RxBus2
import uz.wiut.lineup.lineup.model.History
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization
import uz.wiut.lineup.lineup.ui.organizationDetails.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.utils.events.ItemRemove
import uz.wiut.lineup.lineup.utils.events.OrgDetails
import javax.inject.Inject

/**
 * Created by Shohruh on 20-Apr-18.
 */
class HomeFragmentPresenterImpl : HomeFragmentPresenter {
    @Inject
    lateinit var view : HomeFragmentView

    private var mAuth: FirebaseAuth?
    private var dbRef: DatabaseReference
    private var dbQueueRegedRef: DatabaseReference
    private var dbOrganizationRef: DatabaseReference
    private var uid: String?

    private var queuesReged = ArrayList<RegisteredOrganization>()
    private var orgs = ArrayList<Organization>()

    @Inject
    constructor(){
        mAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference()
        dbQueueRegedRef = dbRef.child("v1/usersList/clients")
        dbOrganizationRef = dbRef.child("v1/organization")
        uid = mAuth?.currentUser?.uid
    }

    override fun onLoadData() {
        loadRegedQueus()
    }

    private fun loadRegedQueus() {
        dbQueueRegedRef.child("${uid}/dQId").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (!dataSnapshot.hasChildren()) return
                queuesReged.clear()
                for (postSnapshot in dataSnapshot.children) {
                    var data = dataSnapshot.child(postSnapshot.key).getValue<RegisteredOrganization>(RegisteredOrganization::class.java)
                    data?.queueId = dataSnapshot.key
                    queuesReged.add(data!!)

                }
                loadOrganizations()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                view.log("dbHistoryRef - The read failed: " + databaseError.code)
                view.message("Failed connecting to server!")
            }
        })
    }

    private fun loadOrganizations() {
        orgs.clear()
        var count = queuesReged.count() -1
        for (j in 0 .. count) {
            var i = queuesReged[j]
            dbOrganizationRef.child("${i.location}/${i.category}/${i.oId}").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    view.log("dbOrganizationRef - IN")
                    if (!dataSnapshot.hasChildren()) return
                    orgs.add(dataSnapshot.getValue<Organization>(Organization::class.java)!!)
                    if (j == count) {
                        view.setQueueData(queuesReged)
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
    }

    override fun subscribeRxBus() {
        RxBus2.subscribe(RxBus2.ITEM_DELETE, this, Consumer { o ->
            if (o is OrgDetails) {
                startActivityDetailsOrg(o)
            }
        })
    }

    override fun onDestroy(){
        RxBus2.unregister(this)
    }

    private fun startActivityDetailsOrg(orgDetails: OrgDetails){
        view.startActivity(OrganizationDetailsActivity(), orgDetails)
    }
}